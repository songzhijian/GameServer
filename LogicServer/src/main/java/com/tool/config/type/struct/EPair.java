package com.tool.config.type.struct;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class EPair<F, S> implements Serializable {

    private static final long serialVersionUID = -5760246442087683504L;
    private F first;
    private S second;


    public EPair() {
    }

    public EPair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public static <F, S> EPair<F, S> of(F first, S second) {
        return new EPair<>(first, second);
    }

    public F getFirst() {
        return first;
    }

    public void setFirst(F first) {
        this.first = first;
    }

    public S getSecond() {
        return second;
    }

    public void setSecond(S second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return first + "," + second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EPair)) return false;
        EPair<?, ?> pair = (EPair<?, ?>) o;
        return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
