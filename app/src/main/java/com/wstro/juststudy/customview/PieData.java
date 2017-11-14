package com.wstro.juststudy.customview;

/**
 * ClassName: PieData
 * Function:
 * Date:     2017/11/10 0010 11:58
 *
 * @author pengl
 * @see
 */
public class PieData {
    private String name;
    private float value;

    private float percent;

    private float angel;
    private int color;

    public PieData(String name, float value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public float getAngel() {
        return angel;
    }

    public void setAngel(float angel) {
        this.angel = angel;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
