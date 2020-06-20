package filters;

public class Color {
    int a, r, g, b;

    public Color(int argb) {
        this.a = (argb>>24) & 0xff;
        this.r = (argb>>16) & 0xff;
        this.g = (argb>>8) & 0xff;
        this.b = argb & 0xff;
    }

    public Color(int a, int r, int g, int b) {
        this.a = a;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public int toARGB() {
        return (a<<24) | (r<<16) | (g<<8) | b;
    }
}
