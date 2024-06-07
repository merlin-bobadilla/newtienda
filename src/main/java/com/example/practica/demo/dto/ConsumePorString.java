
package com.example.practica.demo.dto;

import java.util.Objects;


public class ConsumePorString {
    private String string;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return "ConsumePorString{" + "string=" + string + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.string);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ConsumePorString other = (ConsumePorString) obj;
        return Objects.equals(this.string, other.string);
    }
    
    
    
}
