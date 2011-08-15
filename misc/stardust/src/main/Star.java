import java.awt.*;
import java.awt.geom.GeneralPath;

public class Star {
	private double x;
	private double y;
	private float alpha;
	private double outerSpan;
	private Color color;
	private float rotation;

	public Star(double startX, double startY, double startOuterSpan) {
		this.x = startX;
		this.y = startY;
		this.outerSpan = startOuterSpan;
		this.color = Color.white;

		this.alpha = 1.0f;
		this.rotation = 0.0f;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setAlpha(float alpha) {
		this.alpha = alpha;
	}

	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

	public void setOuterSpan(double outerSpan) {
		this.outerSpan = outerSpan;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Shape getCurrentShape() {
		double innerSpan = this.outerSpan * (0.1f + 0.1f * outerSpan / 20);
		int POINTS = 5;
		GeneralPath result = new GeneralPath();
		for (int i = 0; i < POINTS; i++) {
			double outerAngle = this.rotation + i * 2 * Math.PI / POINTS;
			double xOuter = this.x + this.outerSpan * Math.cos(outerAngle);
			double yOuter = this.y + this.outerSpan * Math.sin(outerAngle);
			if (i == 0) {
				result.moveTo(xOuter, yOuter);
			} else {
				result.lineTo(xOuter, yOuter);
			}
			double innerAngle = outerAngle + Math.PI / POINTS;
			double xInner = this.x + innerSpan * Math.cos(innerAngle);
			double yInner = this.y + innerSpan * Math.sin(innerAngle);
			result.lineTo(xInner, yInner);
		}
		result.closePath();
		return result;
	}
}
