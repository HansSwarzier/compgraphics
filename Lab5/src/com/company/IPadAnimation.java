package com.company;

import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.swing.*;
import javax.vecmath.Vector3f;
import java.awt.event.*;

public class IPadAnimation extends KeyAdapter implements ActionListener {
    private static final float DELTA_DISTANCE = 0.02f;
    private static final float DELTA_ANGLE = 0.05f;

    private TransformGroup mouseTransformGroup;
    private Transform3D transform3D = new Transform3D();
    private float xLoc = 0;
    private float yLoc = 0;

    private boolean isRotatedPosZ = false;
    private boolean isRotatedNegZ = false;

    private boolean pressedW = false;
    private boolean pressedS = false;
    private boolean pressedA = false;
    private boolean pressedD = false;
    private boolean pressedZ = false;
    private boolean pressedX = false;

    private boolean pressedVKRight = false;
    private boolean pressedVKLeft = false;
    private boolean pressedVKUp = false;
    private boolean pressedVKDown = false;

    IPadAnimation(IPad lego) {
        this.mouseTransformGroup = lego.getLegoTransformGroup();
        this.mouseTransformGroup.getTransform(this.transform3D);

        Timer timer = new Timer(20, this);
        timer.start();
    }

    private void Move() {
        if (pressedW)
            yLoc += DELTA_DISTANCE;

        if (pressedS)
            yLoc -= DELTA_DISTANCE;

        if (pressedA)
            xLoc -= DELTA_DISTANCE;

        if (pressedD)
            xLoc += DELTA_DISTANCE;

        transform3D.setTranslation(new Vector3f(xLoc, yLoc, 0));

        if (pressedVKRight) {
            Transform3D rotation = new Transform3D();
            rotation.rotY(DELTA_ANGLE);
            transform3D.mul(rotation);
        }
        //if(is)

        if (pressedVKLeft) {
            Transform3D rotation = new Transform3D();
            rotation.rotY(-DELTA_ANGLE);
            transform3D.mul(rotation);
        }

        if (pressedVKUp) {
            Transform3D rotation = new Transform3D();
            rotation.rotX(-DELTA_ANGLE);
            transform3D.mul(rotation);
        }

        if (pressedVKDown) {
            Transform3D rotation = new Transform3D();
            rotation.rotX(DELTA_ANGLE);
            transform3D.mul(rotation);
        }

        if (isRotatedPosZ) {
            Transform3D rotation = new Transform3D();
            rotation.rotZ(degree(3));
            transform3D.mul(rotation);

            //isRotatedPosZ = false;
        }

        if (isRotatedNegZ) {
            Transform3D rotation = new Transform3D();
            rotation.rotZ(degree(-3));
            transform3D.mul(rotation);

            //isRotatedNegZ = false;
        }
        if(pressedZ){
            Transform3D zoom = new Transform3D();
            zoom.setScale(1.1);
            transform3D.mul(zoom);
        }
        if (pressedX){
            Transform3D zoom = new Transform3D();
            zoom.setScale(0.9);
            transform3D.mul(zoom);
        }
        mouseTransformGroup.setTransform(transform3D);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Move();
    }

    @Override
    public void keyPressed(KeyEvent ev) {
        switch (ev.getKeyCode()) {
            case 87: // W
                pressedW = true;
                break;
            case 83: // S
                pressedS = true;
                break;
            case 65: // A
                pressedA = true;
                break;
            case 68: // D
                pressedD = true;
                break;
            case KeyEvent.VK_LEFT:
                pressedVKLeft = true;
                break;
            case KeyEvent.VK_RIGHT:
                pressedVKRight = true;
                break;
            case KeyEvent.VK_UP:
                pressedVKUp = true;
                break;
            case KeyEvent.VK_DOWN:
                pressedVKDown = true;
                break;
            case 81: //Q
                isRotatedPosZ = true;
                break;
            case 69: //E
                isRotatedNegZ = true;
                break;
            case 90: //Z:
                pressedZ = true;
                break;
            case KeyEvent.VK_X:
                pressedX = true;
                break;
        }
    }



    @Override
    public void keyReleased(KeyEvent ev) {
        switch (ev.getKeyCode()) {
            case 87: // W
                pressedW = false;
                break;
            case 83: // S
                pressedS = false;
                break;
            case 65: // A
                pressedA = false;
                break;
            case 68: // D
                pressedD = false;
                break;
            case KeyEvent.VK_RIGHT:
                pressedVKRight = false;
                break;
            case KeyEvent.VK_LEFT:
                pressedVKLeft = false;
                break;
            case KeyEvent.VK_UP:
                pressedVKUp = false;
                break;
            case KeyEvent.VK_DOWN:
                pressedVKDown = false;
                break;
            case 81: //Q
                isRotatedPosZ = false;
                break;
            case 69: //E
                isRotatedNegZ = false;
                break;
            case 90:
                pressedZ=false;
                break;
            case KeyEvent.VK_X:
                pressedX=false;
                break;
        }
    }

    private float degree(float degrees) {
        return (float) (degrees * Math.PI / 180);
    }
}
