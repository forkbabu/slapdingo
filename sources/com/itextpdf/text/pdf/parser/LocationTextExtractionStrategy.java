package com.itextpdf.text.pdf.parser;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LocationTextExtractionStrategy implements TextExtractionStrategy {
    static boolean DUMP_STATE = false;
    private final List<TextChunk> locationalResult;
    private final TextChunkLocationStrategy tclStrat;

    public interface TextChunkFilter {
        boolean accept(TextChunk textChunk);
    }

    public interface TextChunkLocation extends Comparable<TextChunkLocation> {
        float distParallelEnd();

        float distParallelStart();

        int distPerpendicular();

        float distanceFromEndOf(TextChunkLocation textChunkLocation);

        float getCharSpaceWidth();

        Vector getEndLocation();

        Vector getStartLocation();

        boolean isAtWordBoundary(TextChunkLocation textChunkLocation);

        int orientationMagnitude();

        boolean sameLine(TextChunkLocation textChunkLocation);
    }

    public interface TextChunkLocationStrategy {
        TextChunkLocation createLocation(TextRenderInfo textRenderInfo, LineSegment lineSegment);
    }

    /* access modifiers changed from: private */
    public static int compareInts(int i, int i2) {
        if (i == i2) {
            return 0;
        }
        return i < i2 ? -1 : 1;
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void beginTextBlock() {
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void endTextBlock() {
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void renderImage(ImageRenderInfo imageRenderInfo) {
    }

    public LocationTextExtractionStrategy() {
        this(new TextChunkLocationStrategy() {
            /* class com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy.AnonymousClass1 */

            @Override // com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy.TextChunkLocationStrategy
            public TextChunkLocation createLocation(TextRenderInfo textRenderInfo, LineSegment lineSegment) {
                return new TextChunkLocationDefaultImp(lineSegment.getStartPoint(), lineSegment.getEndPoint(), textRenderInfo.getSingleSpaceWidth());
            }
        });
    }

    public LocationTextExtractionStrategy(TextChunkLocationStrategy textChunkLocationStrategy) {
        this.locationalResult = new ArrayList();
        this.tclStrat = textChunkLocationStrategy;
    }

    private boolean startsWithSpace(String str) {
        if (str.length() != 0 && str.charAt(0) == ' ') {
            return true;
        }
        return false;
    }

    private boolean endsWithSpace(String str) {
        if (str.length() != 0 && str.charAt(str.length() - 1) == ' ') {
            return true;
        }
        return false;
    }

    private List<TextChunk> filterTextChunks(List<TextChunk> list, TextChunkFilter textChunkFilter) {
        if (textChunkFilter == null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (TextChunk textChunk : list) {
            if (textChunkFilter.accept(textChunk)) {
                arrayList.add(textChunk);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public boolean isChunkAtWordBoundary(TextChunk textChunk, TextChunk textChunk2) {
        return textChunk.getLocation().isAtWordBoundary(textChunk2.getLocation());
    }

    public String getResultantText(TextChunkFilter textChunkFilter) {
        if (DUMP_STATE) {
            dumpState();
        }
        List<TextChunk> filterTextChunks = filterTextChunks(this.locationalResult, textChunkFilter);
        Collections.sort(filterTextChunks);
        StringBuilder sb = new StringBuilder();
        TextChunk textChunk = null;
        for (TextChunk textChunk2 : filterTextChunks) {
            if (textChunk == null) {
                sb.append(textChunk2.text);
            } else if (textChunk2.sameLine(textChunk)) {
                if (isChunkAtWordBoundary(textChunk2, textChunk) && !startsWithSpace(textChunk2.text) && !endsWithSpace(textChunk.text)) {
                    sb.append(' ');
                }
                sb.append(textChunk2.text);
            } else {
                sb.append('\n');
                sb.append(textChunk2.text);
            }
            textChunk = textChunk2;
        }
        return sb.toString();
    }

    @Override // com.itextpdf.text.pdf.parser.TextExtractionStrategy
    public String getResultantText() {
        return getResultantText(null);
    }

    private void dumpState() {
        for (TextChunk textChunk : this.locationalResult) {
            textChunk.printDiagnostics();
            System.out.println();
        }
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void renderText(TextRenderInfo textRenderInfo) {
        LineSegment baseline = textRenderInfo.getBaseline();
        if (textRenderInfo.getRise() != 0.0f) {
            baseline = baseline.transformBy(new Matrix(0.0f, -textRenderInfo.getRise()));
        }
        this.locationalResult.add(new TextChunk(textRenderInfo.getText(), this.tclStrat.createLocation(textRenderInfo, baseline)));
    }

    public static class TextChunkLocationDefaultImp implements TextChunkLocation {
        private final float charSpaceWidth;
        private final float distParallelEnd;
        private final float distParallelStart;
        private final int distPerpendicular;
        private final Vector endLocation;
        private final int orientationMagnitude;
        private final Vector orientationVector;
        private final Vector startLocation;

        public TextChunkLocationDefaultImp(Vector vector, Vector vector2, float f) {
            this.startLocation = vector;
            this.endLocation = vector2;
            this.charSpaceWidth = f;
            Vector subtract = vector2.subtract(vector);
            Vector normalize = (subtract.length() == 0.0f ? new Vector(1.0f, 0.0f, 0.0f) : subtract).normalize();
            this.orientationVector = normalize;
            this.orientationMagnitude = (int) (Math.atan2((double) normalize.get(1), (double) this.orientationVector.get(0)) * 1000.0d);
            this.distPerpendicular = (int) vector.subtract(new Vector(0.0f, 0.0f, 1.0f)).cross(this.orientationVector).get(2);
            this.distParallelStart = this.orientationVector.dot(vector);
            this.distParallelEnd = this.orientationVector.dot(vector2);
        }

        @Override // com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy.TextChunkLocation
        public int orientationMagnitude() {
            return this.orientationMagnitude;
        }

        @Override // com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy.TextChunkLocation
        public int distPerpendicular() {
            return this.distPerpendicular;
        }

        @Override // com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy.TextChunkLocation
        public float distParallelStart() {
            return this.distParallelStart;
        }

        @Override // com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy.TextChunkLocation
        public float distParallelEnd() {
            return this.distParallelEnd;
        }

        @Override // com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy.TextChunkLocation
        public Vector getStartLocation() {
            return this.startLocation;
        }

        @Override // com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy.TextChunkLocation
        public Vector getEndLocation() {
            return this.endLocation;
        }

        @Override // com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy.TextChunkLocation
        public float getCharSpaceWidth() {
            return this.charSpaceWidth;
        }

        @Override // com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy.TextChunkLocation
        public boolean sameLine(TextChunkLocation textChunkLocation) {
            return orientationMagnitude() == textChunkLocation.orientationMagnitude() && distPerpendicular() == textChunkLocation.distPerpendicular();
        }

        @Override // com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy.TextChunkLocation
        public float distanceFromEndOf(TextChunkLocation textChunkLocation) {
            return distParallelStart() - textChunkLocation.distParallelEnd();
        }

        @Override // com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy.TextChunkLocation
        public boolean isAtWordBoundary(TextChunkLocation textChunkLocation) {
            if (getCharSpaceWidth() < 0.1f) {
                return false;
            }
            float distanceFromEndOf = distanceFromEndOf(textChunkLocation);
            if (distanceFromEndOf < (-getCharSpaceWidth()) || distanceFromEndOf > getCharSpaceWidth() / 2.0f) {
                return true;
            }
            return false;
        }

        public int compareTo(TextChunkLocation textChunkLocation) {
            if (this == textChunkLocation) {
                return 0;
            }
            int access$300 = LocationTextExtractionStrategy.compareInts(orientationMagnitude(), textChunkLocation.orientationMagnitude());
            if (access$300 != 0) {
                return access$300;
            }
            int access$3002 = LocationTextExtractionStrategy.compareInts(distPerpendicular(), textChunkLocation.distPerpendicular());
            if (access$3002 != 0) {
                return access$3002;
            }
            return Float.compare(distParallelStart(), textChunkLocation.distParallelStart());
        }
    }

    public static class TextChunk implements Comparable<TextChunk> {
        private final TextChunkLocation location;
        /* access modifiers changed from: private */
        public final String text;

        public TextChunk(String str, Vector vector, Vector vector2, float f) {
            this(str, new TextChunkLocationDefaultImp(vector, vector2, f));
        }

        public TextChunk(String str, TextChunkLocation textChunkLocation) {
            this.text = str;
            this.location = textChunkLocation;
        }

        public String getText() {
            return this.text;
        }

        public TextChunkLocation getLocation() {
            return this.location;
        }

        public Vector getStartLocation() {
            return this.location.getStartLocation();
        }

        public Vector getEndLocation() {
            return this.location.getEndLocation();
        }

        public float getCharSpaceWidth() {
            return this.location.getCharSpaceWidth();
        }

        public float distanceFromEndOf(TextChunk textChunk) {
            return this.location.distanceFromEndOf(textChunk.location);
        }

        /* access modifiers changed from: private */
        public void printDiagnostics() {
            PrintStream printStream = System.out;
            printStream.println("Text (@" + this.location.getStartLocation() + " -> " + this.location.getEndLocation() + "): " + this.text);
            PrintStream printStream2 = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("orientationMagnitude: ");
            sb.append(this.location.orientationMagnitude());
            printStream2.println(sb.toString());
            PrintStream printStream3 = System.out;
            printStream3.println("distPerpendicular: " + this.location.distPerpendicular());
            PrintStream printStream4 = System.out;
            printStream4.println("distParallel: " + this.location.distParallelStart());
        }

        public int compareTo(TextChunk textChunk) {
            return this.location.compareTo(textChunk.location);
        }

        /* access modifiers changed from: private */
        public boolean sameLine(TextChunk textChunk) {
            return getLocation().sameLine(textChunk.getLocation());
        }
    }
}
