package com.itextpdf.text;

import java.io.Serializable;

public class AccessibleElementId implements Comparable<AccessibleElementId>, Serializable {
    private static int id_counter;

    /* renamed from: id  reason: collision with root package name */
    private int f38id = 0;

    public AccessibleElementId() {
        int i = id_counter + 1;
        id_counter = i;
        this.f38id = i;
    }

    public String toString() {
        return Integer.toString(this.f38id);
    }

    public int hashCode() {
        return this.f38id;
    }

    public boolean equals(Object obj) {
        return (obj instanceof AccessibleElementId) && this.f38id == ((AccessibleElementId) obj).f38id;
    }

    public int compareTo(AccessibleElementId accessibleElementId) {
        int i = this.f38id;
        int i2 = accessibleElementId.f38id;
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }
}
