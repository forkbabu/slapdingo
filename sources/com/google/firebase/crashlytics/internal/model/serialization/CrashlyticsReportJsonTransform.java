package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.Base64;
import android.util.JsonReader;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

public class CrashlyticsReportJsonTransform {
    private static final DataEncoder CRASHLYTICS_REPORT_JSON_ENCODER = new JsonDataEncoderBuilder().configureWith(AutoCrashlyticsReportEncoder.CONFIG).ignoreNullValues(true).build();

    /* access modifiers changed from: private */
    public interface ObjectParser<T> {
        T parse(JsonReader jsonReader) throws IOException;
    }

    public String reportToJson(CrashlyticsReport crashlyticsReport) {
        return CRASHLYTICS_REPORT_JSON_ENCODER.encode(crashlyticsReport);
    }

    public String eventToJson(CrashlyticsReport.Session.Event event) {
        return CRASHLYTICS_REPORT_JSON_ENCODER.encode(event);
    }

    public CrashlyticsReport reportFromJson(String str) throws IOException {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            try {
                CrashlyticsReport parseReport = parseReport(jsonReader);
                jsonReader.close();
                return parseReport;
            } catch (Throwable unused) {
            }
            throw th;
        } catch (IllegalStateException e) {
            throw new IOException(e);
        }
    }

    public CrashlyticsReport.Session.Event eventFromJson(String str) throws IOException {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            try {
                CrashlyticsReport.Session.Event parseEvent = parseEvent(jsonReader);
                jsonReader.close();
                return parseEvent;
            } catch (Throwable unused) {
            }
            throw th;
        } catch (IllegalStateException e) {
            throw new IOException(e);
        }
    }

    private static CrashlyticsReport parseReport(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Builder builder = CrashlyticsReport.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -2118372775:
                    if (nextName.equals("ndkPayload")) {
                        c = 7;
                        break;
                    }
                    break;
                case -1962630338:
                    if (nextName.equals("sdkVersion")) {
                        c = 0;
                        break;
                    }
                    break;
                case -911706486:
                    if (nextName.equals("buildVersion")) {
                        c = 4;
                        break;
                    }
                    break;
                case 344431858:
                    if (nextName.equals("gmpAppId")) {
                        c = 1;
                        break;
                    }
                    break;
                case 719853845:
                    if (nextName.equals("installationUuid")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1874684019:
                    if (nextName.equals("platform")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1975623094:
                    if (nextName.equals("displayVersion")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1984987798:
                    if (nextName.equals("session")) {
                        c = 6;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    builder.setSdkVersion(jsonReader.nextString());
                    break;
                case 1:
                    builder.setGmpAppId(jsonReader.nextString());
                    break;
                case 2:
                    builder.setPlatform(jsonReader.nextInt());
                    break;
                case 3:
                    builder.setInstallationUuid(jsonReader.nextString());
                    break;
                case 4:
                    builder.setBuildVersion(jsonReader.nextString());
                    break;
                case 5:
                    builder.setDisplayVersion(jsonReader.nextString());
                    break;
                case 6:
                    builder.setSession(parseSession(jsonReader));
                    break;
                case 7:
                    builder.setNdkPayload(parseNdkPayload(jsonReader));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session parseSession(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Builder builder = CrashlyticsReport.Session.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -2128794476:
                    if (nextName.equals("startedAt")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1618432855:
                    if (nextName.equals(DublinCoreProperties.IDENTIFIER)) {
                        c = 1;
                        break;
                    }
                    break;
                case -1606742899:
                    if (nextName.equals("endedAt")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1335157162:
                    if (nextName.equals("device")) {
                        c = '\b';
                        break;
                    }
                    break;
                case -1291329255:
                    if (nextName.equals("events")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 3556:
                    if (nextName.equals("os")) {
                        c = 7;
                        break;
                    }
                    break;
                case 96801:
                    if (nextName.equals("app")) {
                        c = 6;
                        break;
                    }
                    break;
                case 3599307:
                    if (nextName.equals("user")) {
                        c = 5;
                        break;
                    }
                    break;
                case 286956243:
                    if (nextName.equals("generator")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1025385094:
                    if (nextName.equals("crashed")) {
                        c = 4;
                        break;
                    }
                    break;
                case 2047016109:
                    if (nextName.equals("generatorType")) {
                        c = '\n';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    builder.setGenerator(jsonReader.nextString());
                    break;
                case 1:
                    builder.setIdentifierFromUtf8Bytes(Base64.decode(jsonReader.nextString(), 2));
                    break;
                case 2:
                    builder.setStartedAt(jsonReader.nextLong());
                    break;
                case 3:
                    builder.setEndedAt(Long.valueOf(jsonReader.nextLong()));
                    break;
                case 4:
                    builder.setCrashed(jsonReader.nextBoolean());
                    break;
                case 5:
                    builder.setUser(parseUser(jsonReader));
                    break;
                case 6:
                    builder.setApp(parseApp(jsonReader));
                    break;
                case 7:
                    builder.setOs(parseOs(jsonReader));
                    break;
                case '\b':
                    builder.setDevice(parseDevice(jsonReader));
                    break;
                case '\t':
                    builder.setEvents(parseArray(jsonReader, CrashlyticsReportJsonTransform$$Lambda$1.lambdaFactory$()));
                    break;
                case '\n':
                    builder.setGeneratorType(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.FilesPayload parseNdkPayload(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.FilesPayload.Builder builder = CrashlyticsReport.FilesPayload.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 97434231) {
                if (hashCode == 106008351 && nextName.equals("orgId")) {
                    c = 1;
                }
            } else if (nextName.equals("files")) {
                c = 0;
            }
            if (c == 0) {
                builder.setFiles(parseArray(jsonReader, CrashlyticsReportJsonTransform$$Lambda$2.lambdaFactory$()));
            } else if (c != 1) {
                jsonReader.skipValue();
            } else {
                builder.setOrgId(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    /* access modifiers changed from: private */
    public static CrashlyticsReport.FilesPayload.File parseFile(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.FilesPayload.File.Builder builder = CrashlyticsReport.FilesPayload.File.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != -734768633) {
                if (hashCode == -567321830 && nextName.equals("contents")) {
                    c = 1;
                }
            } else if (nextName.equals("filename")) {
                c = 0;
            }
            if (c == 0) {
                builder.setFilename(jsonReader.nextString());
            } else if (c != 1) {
                jsonReader.skipValue();
            } else {
                builder.setContents(Base64.decode(jsonReader.nextString(), 2));
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.User parseUser(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.User.Builder builder = CrashlyticsReport.Session.User.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            if (nextName.hashCode() == -1618432855 && nextName.equals(DublinCoreProperties.IDENTIFIER)) {
                c = 0;
            }
            if (c != 0) {
                jsonReader.skipValue();
            } else {
                builder.setIdentifier(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.Application parseApp(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Application.Builder builder = CrashlyticsReport.Session.Application.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -1618432855:
                    if (nextName.equals(DublinCoreProperties.IDENTIFIER)) {
                        c = 0;
                        break;
                    }
                    break;
                case 351608024:
                    if (nextName.equals("version")) {
                        c = 1;
                        break;
                    }
                    break;
                case 719853845:
                    if (nextName.equals("installationUuid")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1975623094:
                    if (nextName.equals("displayVersion")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                builder.setIdentifier(jsonReader.nextString());
            } else if (c == 1) {
                builder.setVersion(jsonReader.nextString());
            } else if (c == 2) {
                builder.setDisplayVersion(jsonReader.nextString());
            } else if (c != 3) {
                jsonReader.skipValue();
            } else {
                builder.setInstallationUuid(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.OperatingSystem parseOs(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.OperatingSystem.Builder builder = CrashlyticsReport.Session.OperatingSystem.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -911706486:
                    if (nextName.equals("buildVersion")) {
                        c = 2;
                        break;
                    }
                    break;
                case -293026577:
                    if (nextName.equals("jailbroken")) {
                        c = 3;
                        break;
                    }
                    break;
                case 351608024:
                    if (nextName.equals("version")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1874684019:
                    if (nextName.equals("platform")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                builder.setPlatform(jsonReader.nextInt());
            } else if (c == 1) {
                builder.setVersion(jsonReader.nextString());
            } else if (c == 2) {
                builder.setBuildVersion(jsonReader.nextString());
            } else if (c != 3) {
                jsonReader.skipValue();
            } else {
                builder.setJailbroken(jsonReader.nextBoolean());
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.Device parseDevice(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Device.Builder builder = CrashlyticsReport.Session.Device.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -1981332476:
                    if (nextName.equals("simulator")) {
                        c = 5;
                        break;
                    }
                    break;
                case -1969347631:
                    if (nextName.equals("manufacturer")) {
                        c = 7;
                        break;
                    }
                    break;
                case 112670:
                    if (nextName.equals("ram")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3002454:
                    if (nextName.equals("arch")) {
                        c = 0;
                        break;
                    }
                    break;
                case 81784169:
                    if (nextName.equals("diskSpace")) {
                        c = 4;
                        break;
                    }
                    break;
                case 94848180:
                    if (nextName.equals("cores")) {
                        c = 2;
                        break;
                    }
                    break;
                case 104069929:
                    if (nextName.equals("model")) {
                        c = 1;
                        break;
                    }
                    break;
                case 109757585:
                    if (nextName.equals("state")) {
                        c = 6;
                        break;
                    }
                    break;
                case 2078953423:
                    if (nextName.equals("modelClass")) {
                        c = '\b';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    builder.setArch(jsonReader.nextInt());
                    break;
                case 1:
                    builder.setModel(jsonReader.nextString());
                    break;
                case 2:
                    builder.setCores(jsonReader.nextInt());
                    break;
                case 3:
                    builder.setRam(jsonReader.nextLong());
                    break;
                case 4:
                    builder.setDiskSpace(jsonReader.nextLong());
                    break;
                case 5:
                    builder.setSimulator(jsonReader.nextBoolean());
                    break;
                case 6:
                    builder.setState(jsonReader.nextInt());
                    break;
                case 7:
                    builder.setManufacturer(jsonReader.nextString());
                    break;
                case '\b':
                    builder.setModelClass(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    /* access modifiers changed from: private */
    public static CrashlyticsReport.Session.Event parseEvent(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Builder builder = CrashlyticsReport.Session.Event.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -1335157162:
                    if (nextName.equals("device")) {
                        c = 3;
                        break;
                    }
                    break;
                case 96801:
                    if (nextName.equals("app")) {
                        c = 2;
                        break;
                    }
                    break;
                case 107332:
                    if (nextName.equals("log")) {
                        c = 4;
                        break;
                    }
                    break;
                case 3575610:
                    if (nextName.equals("type")) {
                        c = 1;
                        break;
                    }
                    break;
                case 55126294:
                    if (nextName.equals("timestamp")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                builder.setTimestamp(jsonReader.nextLong());
            } else if (c == 1) {
                builder.setType(jsonReader.nextString());
            } else if (c == 2) {
                builder.setApp(parseEventApp(jsonReader));
            } else if (c == 3) {
                builder.setDevice(parseEventDevice(jsonReader));
            } else if (c != 4) {
                jsonReader.skipValue();
            } else {
                builder.setLog(parseEventLog(jsonReader));
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.Event.Application parseEventApp(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Application.Builder builder = CrashlyticsReport.Session.Event.Application.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -1332194002:
                    if (nextName.equals("background")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1090974952:
                    if (nextName.equals("execution")) {
                        c = 2;
                        break;
                    }
                    break;
                case 555169704:
                    if (nextName.equals("customAttributes")) {
                        c = 3;
                        break;
                    }
                    break;
                case 928737948:
                    if (nextName.equals("uiOrientation")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                builder.setBackground(Boolean.valueOf(jsonReader.nextBoolean()));
            } else if (c == 1) {
                builder.setUiOrientation(jsonReader.nextInt());
            } else if (c == 2) {
                builder.setExecution(parseEventExecution(jsonReader));
            } else if (c != 3) {
                jsonReader.skipValue();
            } else {
                builder.setCustomAttributes(parseArray(jsonReader, CrashlyticsReportJsonTransform$$Lambda$3.lambdaFactory$()));
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.Event.Application.Execution parseEventExecution(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Application.Execution.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -1337936983:
                    if (nextName.equals("threads")) {
                        c = 0;
                        break;
                    }
                    break;
                case -902467928:
                    if (nextName.equals("signal")) {
                        c = 2;
                        break;
                    }
                    break;
                case 937615455:
                    if (nextName.equals("binaries")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1481625679:
                    if (nextName.equals("exception")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                builder.setThreads(parseArray(jsonReader, CrashlyticsReportJsonTransform$$Lambda$4.lambdaFactory$()));
            } else if (c == 1) {
                builder.setException(parseEventExecutionException(jsonReader));
            } else if (c == 2) {
                builder.setSignal(parseEventSignal(jsonReader));
            } else if (c != 3) {
                jsonReader.skipValue();
            } else {
                builder.setBinaries(parseArray(jsonReader, CrashlyticsReportJsonTransform$$Lambda$5.lambdaFactory$()));
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.Event.Application.Execution.Exception parseEventExecutionException(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.Exception.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -1266514778:
                    if (nextName.equals("frames")) {
                        c = 1;
                        break;
                    }
                    break;
                case -934964668:
                    if (nextName.equals("reason")) {
                        c = 4;
                        break;
                    }
                    break;
                case 3575610:
                    if (nextName.equals("type")) {
                        c = 3;
                        break;
                    }
                    break;
                case 91997906:
                    if (nextName.equals("causedBy")) {
                        c = 0;
                        break;
                    }
                    break;
                case 581754413:
                    if (nextName.equals("overflowCount")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                builder.setCausedBy(parseEventExecutionException(jsonReader));
            } else if (c == 1) {
                builder.setFrames(parseArray(jsonReader, CrashlyticsReportJsonTransform$$Lambda$6.lambdaFactory$()));
            } else if (c == 2) {
                builder.setOverflowCount(jsonReader.nextInt());
            } else if (c == 3) {
                builder.setType(jsonReader.nextString());
            } else if (c != 4) {
                jsonReader.skipValue();
            } else {
                builder.setReason(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.Event.Application.Execution.Signal parseEventSignal(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.Signal.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != -1147692044) {
                if (hashCode != 3059181) {
                    if (hashCode == 3373707 && nextName.equals(AppMeasurementSdk.ConditionalUserProperty.NAME)) {
                        c = 0;
                    }
                } else if (nextName.equals("code")) {
                    c = 1;
                }
            } else if (nextName.equals("address")) {
                c = 2;
            }
            if (c == 0) {
                builder.setName(jsonReader.nextString());
            } else if (c == 1) {
                builder.setCode(jsonReader.nextString());
            } else if (c != 2) {
                jsonReader.skipValue();
            } else {
                builder.setAddress(jsonReader.nextLong());
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    /* access modifiers changed from: private */
    public static CrashlyticsReport.Session.Event.Application.Execution.BinaryImage parseEventBinaryImage(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case 3373707:
                    if (nextName.equals(AppMeasurementSdk.ConditionalUserProperty.NAME)) {
                        c = 0;
                        break;
                    }
                    break;
                case 3530753:
                    if (nextName.equals(HtmlTags.SIZE)) {
                        c = 2;
                        break;
                    }
                    break;
                case 3601339:
                    if (nextName.equals("uuid")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1153765347:
                    if (nextName.equals("baseAddress")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                builder.setName(jsonReader.nextString());
            } else if (c == 1) {
                builder.setBaseAddress(jsonReader.nextLong());
            } else if (c == 2) {
                builder.setSize(jsonReader.nextLong());
            } else if (c != 3) {
                jsonReader.skipValue();
            } else {
                builder.setUuidFromUtf8Bytes(Base64.decode(jsonReader.nextString(), 2));
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    /* access modifiers changed from: private */
    public static CrashlyticsReport.Session.Event.Application.Execution.Thread parseEventThread(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.Thread.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != -1266514778) {
                if (hashCode != 3373707) {
                    if (hashCode == 2125650548 && nextName.equals("importance")) {
                        c = 0;
                    }
                } else if (nextName.equals(AppMeasurementSdk.ConditionalUserProperty.NAME)) {
                    c = 1;
                }
            } else if (nextName.equals("frames")) {
                c = 2;
            }
            if (c == 0) {
                builder.setImportance(jsonReader.nextInt());
            } else if (c == 1) {
                builder.setName(jsonReader.nextString());
            } else if (c != 2) {
                jsonReader.skipValue();
            } else {
                builder.setFrames(parseArray(jsonReader, CrashlyticsReportJsonTransform$$Lambda$7.lambdaFactory$()));
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    /* access modifiers changed from: private */
    public static CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame parseEventFrame(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -1019779949:
                    if (nextName.equals("offset")) {
                        c = 2;
                        break;
                    }
                    break;
                case -887523944:
                    if (nextName.equals("symbol")) {
                        c = 4;
                        break;
                    }
                    break;
                case 3571:
                    if (nextName.equals("pc")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3143036:
                    if (nextName.equals(Annotation.FILE)) {
                        c = 1;
                        break;
                    }
                    break;
                case 2125650548:
                    if (nextName.equals("importance")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                builder.setImportance(jsonReader.nextInt());
            } else if (c == 1) {
                builder.setFile(jsonReader.nextString());
            } else if (c == 2) {
                builder.setOffset(jsonReader.nextLong());
            } else if (c == 3) {
                builder.setPc(jsonReader.nextLong());
            } else if (c != 4) {
                jsonReader.skipValue();
            } else {
                builder.setSymbol(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.Event.Device parseEventDevice(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Device.Builder builder = CrashlyticsReport.Session.Event.Device.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -1708606089:
                    if (nextName.equals("batteryLevel")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1455558134:
                    if (nextName.equals("batteryVelocity")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1439500848:
                    if (nextName.equals("orientation")) {
                        c = 4;
                        break;
                    }
                    break;
                case 279795450:
                    if (nextName.equals("diskUsed")) {
                        c = 2;
                        break;
                    }
                    break;
                case 976541947:
                    if (nextName.equals("ramUsed")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1516795582:
                    if (nextName.equals("proximityOn")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                builder.setBatteryLevel(Double.valueOf(jsonReader.nextDouble()));
            } else if (c == 1) {
                builder.setBatteryVelocity(jsonReader.nextInt());
            } else if (c == 2) {
                builder.setDiskUsed(jsonReader.nextLong());
            } else if (c == 3) {
                builder.setProximityOn(jsonReader.nextBoolean());
            } else if (c == 4) {
                builder.setOrientation(jsonReader.nextInt());
            } else if (c != 5) {
                jsonReader.skipValue();
            } else {
                builder.setRamUsed(jsonReader.nextLong());
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.Event.Log parseEventLog(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Log.Builder builder = CrashlyticsReport.Session.Event.Log.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            if (nextName.hashCode() == 951530617 && nextName.equals("content")) {
                c = 0;
            }
            if (c != 0) {
                jsonReader.skipValue();
            } else {
                builder.setContent(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    /* access modifiers changed from: private */
    public static CrashlyticsReport.CustomAttribute parseCustomAttribute(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.CustomAttribute.Builder builder = CrashlyticsReport.CustomAttribute.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 106079) {
                if (hashCode == 111972721 && nextName.equals("value")) {
                    c = 1;
                }
            } else if (nextName.equals("key")) {
                c = 0;
            }
            if (c == 0) {
                builder.setKey(jsonReader.nextString());
            } else if (c != 1) {
                jsonReader.skipValue();
            } else {
                builder.setValue(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static <T> ImmutableList<T> parseArray(JsonReader jsonReader, ObjectParser<T> objectParser) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(objectParser.parse(jsonReader));
        }
        jsonReader.endArray();
        return ImmutableList.from(arrayList);
    }
}
