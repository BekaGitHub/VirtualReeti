package de.dfki.common.interfaces;

/**
 * Created by EmpaT on 15.07.2017.
 */
public interface PartsInterface
{
    String getText();
    void setText(String text);
    void set_X_Rotation(int degree);
    void set_Y_Rotation(int degree);
    void set_Z_Rotation(int degree);
    void setTilt(int degree);
    void set_X_Translation(int length);
    void set_Y_Translation(int length);
    void set_Z_Translation(int length);
    void setShape(String s);
    void setRotation(int degree);
    void setTranslation(int length);
    void calculate_X_Rotation(int step);
    void calculate_Y_Rotation(int step);
    void calculate_Z_Rotation(int step);
    void calculate_X_Translation(int step);
    void calculate_Y_Translation(int step);
    void calculate_Z_Translation(int step);
    void calculateShape(int step);
    void reset_X_Rotation();
    void reset_Y_Rotation();
    void reset_Z_Rotation();
    void resetRotation();
    void resetTranslation();
    void calculateRotation(int step);
    void calculateTranslation(int step);
}
