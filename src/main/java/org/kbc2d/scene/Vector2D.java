package org.kbc2d.scene;

public class Vector2D {
    public double x;
    public double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Vector2D other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
    public Vector2D multiply(double scalar) {
        return new Vector2D(this.x * scalar, this.y * scalar);
    }
    public Vector2D subtract(Vector2D other) {
        return new Vector2D(this.x - other.x, this.y - other.y);
    }

    public double cosAngleBetween(Vector2D other) {
        double dot = this.dotProduct(other);
        double magnitudeProduct = this.magnitude() * other.magnitude();

        // Đảm bảo rằng độ chính xác của dot và magnitudeProduct không vượt quá giới hạn [-1, 1]
        dot = Math.max(-1.0, Math.min(1.0, dot / magnitudeProduct));

        return dot;
    }

    public double dotProduct(Vector2D other) {
        return this.x * other.x + this.y * other.y;
    }

    public double magnitude() {
        return Math.sqrt(x * x + y * y);
    }

    public Vector2D vectorBetween(Vector2D point) {
        double deltaX = point.x - this.x;
        double deltaY = point.y - this.y;
        return new Vector2D(deltaX, deltaY);
    }


}