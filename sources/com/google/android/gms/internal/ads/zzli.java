package com.google.android.gms.internal.ads;

import android.util.Log;
import com.applex.snaplingo.util.Constants;
import com.google.android.gms.internal.ads.zzme;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzli {
    private static final int zzayf = zzpo.zzbk("nam");
    private static final int zzayg = zzpo.zzbk("trk");
    private static final int zzayh = zzpo.zzbk("cmt");
    private static final int zzayi = zzpo.zzbk("day");
    private static final int zzayj = zzpo.zzbk("ART");
    private static final int zzayk = zzpo.zzbk("too");
    private static final int zzayl = zzpo.zzbk("alb");
    private static final int zzaym = zzpo.zzbk("com");
    private static final int zzayn = zzpo.zzbk("wrt");
    private static final int zzayo = zzpo.zzbk("lyr");
    private static final int zzayp = zzpo.zzbk("gen");
    private static final int zzayq = zzpo.zzbk("covr");
    private static final int zzayr = zzpo.zzbk("gnre");
    private static final int zzays = zzpo.zzbk("grp");
    private static final int zzayt = zzpo.zzbk("disk");
    private static final int zzayu = zzpo.zzbk("trkn");
    private static final int zzayv = zzpo.zzbk("tmpo");
    private static final int zzayw = zzpo.zzbk("cpil");
    private static final int zzayx = zzpo.zzbk("aART");
    private static final int zzayy = zzpo.zzbk("sonm");
    private static final int zzayz = zzpo.zzbk("soal");
    private static final int zzaza = zzpo.zzbk("soar");
    private static final int zzazb = zzpo.zzbk("soaa");
    private static final int zzazc = zzpo.zzbk("soco");
    private static final int zzazd = zzpo.zzbk("rtng");
    private static final int zzaze = zzpo.zzbk("pgap");
    private static final int zzazf = zzpo.zzbk("sosn");
    private static final int zzazg = zzpo.zzbk("tvsh");
    private static final int zzazh = zzpo.zzbk("----");
    private static final String[] zzazi = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    public static zzme.zza zzd(zzpi zzpi) {
        int position = zzpi.getPosition() + zzpi.readInt();
        int readInt = zzpi.readInt();
        int i = readInt >>> 24;
        zzml zzml = null;
        if (i == 169 || i == 65533) {
            int i2 = 16777215 & readInt;
            if (i2 == zzayh) {
                int readInt2 = zzpi.readInt();
                if (zzpi.readInt() == zzkt.zzavu) {
                    zzpi.zzbl(8);
                    String zzbm = zzpi.zzbm(readInt2 - 16);
                    zzml = new zzmg("und", zzbm, zzbm);
                } else {
                    String valueOf = String.valueOf(zzkt.zzau(readInt));
                    Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse comment attribute: ".concat(valueOf) : new String("Failed to parse comment attribute: "));
                }
                zzpi.zzbk(position);
                return zzml;
            } else if (i2 == zzayf || i2 == zzayg) {
                zzmk zza = zza(readInt, "TIT2", zzpi);
                zzpi.zzbk(position);
                return zza;
            } else if (i2 == zzaym || i2 == zzayn) {
                zzmk zza2 = zza(readInt, "TCOM", zzpi);
                zzpi.zzbk(position);
                return zza2;
            } else if (i2 == zzayi) {
                zzmk zza3 = zza(readInt, "TDRC", zzpi);
                zzpi.zzbk(position);
                return zza3;
            } else if (i2 == zzayj) {
                zzmk zza4 = zza(readInt, "TPE1", zzpi);
                zzpi.zzbk(position);
                return zza4;
            } else if (i2 == zzayk) {
                zzmk zza5 = zza(readInt, "TSSE", zzpi);
                zzpi.zzbk(position);
                return zza5;
            } else if (i2 == zzayl) {
                zzmk zza6 = zza(readInt, "TALB", zzpi);
                zzpi.zzbk(position);
                return zza6;
            } else if (i2 == zzayo) {
                zzmk zza7 = zza(readInt, "USLT", zzpi);
                zzpi.zzbk(position);
                return zza7;
            } else if (i2 == zzayp) {
                zzmk zza8 = zza(readInt, "TCON", zzpi);
                zzpi.zzbk(position);
                return zza8;
            } else if (i2 == zzays) {
                zzmk zza9 = zza(readInt, "TIT1", zzpi);
                zzpi.zzbk(position);
                return zza9;
            }
        } else {
            try {
                if (readInt == zzayr) {
                    int zze = zze(zzpi);
                    String str = (zze <= 0 || zze > zzazi.length) ? null : zzazi[zze - 1];
                    if (str != null) {
                        zzml = new zzmk("TCON", null, str);
                    } else {
                        Log.w("MetadataUtil", "Failed to parse standard genre code");
                    }
                    return zzml;
                } else if (readInt == zzayt) {
                    zzmk zzb = zzb(readInt, "TPOS", zzpi);
                    zzpi.zzbk(position);
                    return zzb;
                } else if (readInt == zzayu) {
                    zzmk zzb2 = zzb(readInt, "TRCK", zzpi);
                    zzpi.zzbk(position);
                    return zzb2;
                } else if (readInt == zzayv) {
                    zzml zza10 = zza(readInt, "TBPM", zzpi, true, false);
                    zzpi.zzbk(position);
                    return zza10;
                } else if (readInt == zzayw) {
                    zzml zza11 = zza(readInt, "TCMP", zzpi, true, true);
                    zzpi.zzbk(position);
                    return zza11;
                } else if (readInt == zzayq) {
                    int readInt3 = zzpi.readInt();
                    if (zzpi.readInt() == zzkt.zzavu) {
                        int zzat = zzkt.zzat(zzpi.readInt());
                        String str2 = zzat == 13 ? "image/jpeg" : zzat == 14 ? "image/png" : null;
                        if (str2 == null) {
                            StringBuilder sb = new StringBuilder(41);
                            sb.append("Unrecognized cover art flags: ");
                            sb.append(zzat);
                            Log.w("MetadataUtil", sb.toString());
                        } else {
                            zzpi.zzbl(4);
                            int i3 = readInt3 - 16;
                            byte[] bArr = new byte[i3];
                            zzpi.zze(bArr, 0, i3);
                            zzml = new zzmf(str2, null, 3, bArr);
                        }
                    } else {
                        Log.w("MetadataUtil", "Failed to parse cover art attribute");
                    }
                    zzpi.zzbk(position);
                    return zzml;
                } else if (readInt == zzayx) {
                    zzmk zza12 = zza(readInt, "TPE2", zzpi);
                    zzpi.zzbk(position);
                    return zza12;
                } else if (readInt == zzayy) {
                    zzmk zza13 = zza(readInt, "TSOT", zzpi);
                    zzpi.zzbk(position);
                    return zza13;
                } else if (readInt == zzayz) {
                    zzmk zza14 = zza(readInt, "TSO2", zzpi);
                    zzpi.zzbk(position);
                    return zza14;
                } else if (readInt == zzaza) {
                    zzmk zza15 = zza(readInt, "TSOA", zzpi);
                    zzpi.zzbk(position);
                    return zza15;
                } else if (readInt == zzazb) {
                    zzmk zza16 = zza(readInt, "TSOP", zzpi);
                    zzpi.zzbk(position);
                    return zza16;
                } else if (readInt == zzazc) {
                    zzmk zza17 = zza(readInt, "TSOC", zzpi);
                    zzpi.zzbk(position);
                    return zza17;
                } else if (readInt == zzazd) {
                    zzml zza18 = zza(readInt, "ITUNESADVISORY", zzpi, false, false);
                    zzpi.zzbk(position);
                    return zza18;
                } else if (readInt == zzaze) {
                    zzml zza19 = zza(readInt, "ITUNESGAPLESS", zzpi, false, true);
                    zzpi.zzbk(position);
                    return zza19;
                } else if (readInt == zzazf) {
                    zzmk zza20 = zza(readInt, "TVSHOWSORT", zzpi);
                    zzpi.zzbk(position);
                    return zza20;
                } else if (readInt == zzazg) {
                    zzmk zza21 = zza(readInt, "TVSHOW", zzpi);
                    zzpi.zzbk(position);
                    return zza21;
                } else if (readInt == zzazh) {
                    String str3 = null;
                    String str4 = null;
                    int i4 = -1;
                    int i5 = -1;
                    while (zzpi.getPosition() < position) {
                        int position2 = zzpi.getPosition();
                        int readInt4 = zzpi.readInt();
                        int readInt5 = zzpi.readInt();
                        zzpi.zzbl(4);
                        if (readInt5 == zzkt.zzavs) {
                            str3 = zzpi.zzbm(readInt4 - 12);
                        } else if (readInt5 == zzkt.zzavt) {
                            str4 = zzpi.zzbm(readInt4 - 12);
                        } else {
                            if (readInt5 == zzkt.zzavu) {
                                i4 = position2;
                                i5 = readInt4;
                            }
                            zzpi.zzbl(readInt4 - 12);
                        }
                    }
                    if ("com.apple.iTunes".equals(str3) && "iTunSMPB".equals(str4) && i4 != -1) {
                        zzpi.zzbk(i4);
                        zzpi.zzbl(16);
                        zzml = new zzmg("und", str4, zzpi.zzbm(i5 - 16));
                    }
                    zzpi.zzbk(position);
                    return zzml;
                }
            } finally {
                zzpi.zzbk(position);
            }
        }
        String valueOf2 = String.valueOf(zzkt.zzau(readInt));
        Log.d("MetadataUtil", valueOf2.length() != 0 ? "Skipped unknown metadata entry: ".concat(valueOf2) : new String("Skipped unknown metadata entry: "));
        zzpi.zzbk(position);
        return null;
    }

    private static zzmk zza(int i, String str, zzpi zzpi) {
        int readInt = zzpi.readInt();
        if (zzpi.readInt() == zzkt.zzavu) {
            zzpi.zzbl(8);
            return new zzmk(str, null, zzpi.zzbm(readInt - 16));
        }
        String valueOf = String.valueOf(zzkt.zzau(i));
        Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse text attribute: ".concat(valueOf) : new String("Failed to parse text attribute: "));
        return null;
    }

    private static zzml zza(int i, String str, zzpi zzpi, boolean z, boolean z2) {
        int zze = zze(zzpi);
        if (z2) {
            zze = Math.min(1, zze);
        }
        if (zze < 0) {
            String valueOf = String.valueOf(zzkt.zzau(i));
            Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse uint8 attribute: ".concat(valueOf) : new String("Failed to parse uint8 attribute: "));
            return null;
        } else if (z) {
            return new zzmk(str, null, Integer.toString(zze));
        } else {
            return new zzmg("und", str, Integer.toString(zze));
        }
    }

    private static zzmk zzb(int i, String str, zzpi zzpi) {
        int readInt = zzpi.readInt();
        if (zzpi.readInt() == zzkt.zzavu && readInt >= 22) {
            zzpi.zzbl(10);
            int readUnsignedShort = zzpi.readUnsignedShort();
            if (readUnsignedShort > 0) {
                StringBuilder sb = new StringBuilder(11);
                sb.append(readUnsignedShort);
                String sb2 = sb.toString();
                int readUnsignedShort2 = zzpi.readUnsignedShort();
                if (readUnsignedShort2 > 0) {
                    String valueOf = String.valueOf(sb2);
                    StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 12);
                    sb3.append(valueOf);
                    sb3.append(Constants.PATH_SEPERATOR);
                    sb3.append(readUnsignedShort2);
                    sb2 = sb3.toString();
                }
                return new zzmk(str, null, sb2);
            }
        }
        String valueOf2 = String.valueOf(zzkt.zzau(i));
        Log.w("MetadataUtil", valueOf2.length() != 0 ? "Failed to parse index/count attribute: ".concat(valueOf2) : new String("Failed to parse index/count attribute: "));
        return null;
    }

    private static int zze(zzpi zzpi) {
        zzpi.zzbl(4);
        if (zzpi.readInt() == zzkt.zzavu) {
            zzpi.zzbl(8);
            return zzpi.readUnsignedByte();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }
}
