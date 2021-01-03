package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.export.binary.BinaryImporter;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.internal.util.StaticProperty.userHome;

import com.jme3.math.Vector3f;
import com.jme3.renderer.Statistics;
import com.jme3.scene.Spatial;
import com.jme3.scene.Spatial.CullHint;
import com.jme3.system.AppSettings;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

//import com.jme3.app.SimpleApplication;
//import com.jme3.material.Material;
//import com.jme3.math.ColorRGBA;
//import com.jme3.renderer.RenderManager;
//import com.jme3.scene.Geometry;
//import com.jme3.scene.shape.Box;
/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    public static void main(String[] args) {
        AppSettings settings = new AppSettings(true);

        Statistics stats;
        
        settings.setTitle("Tower Fencing.");
        settings.setSettingsDialogImage("Interface/splashscreen.png");
        settings.setResolution(640, 480);
        
        Main app = new Main();
        app.setShowSettings(true);
        app.setSettings(settings);
        app.start();
    }

    @Override
    public void simpleInitApp() {
        
        flyCam.setMoveSpeed(10); // increase movement speed
        
        
        Vector3f v  = new Vector3f( 2.0f, 3.0f, -4.0f); // x y z
        float r     = FastMath.DEG_TO_RAD * 45f;
        Quaternion roll045 = new Quaternion();
        roll045.fromAngleAxis( 45 * FastMath.DEG_TO_RAD, Vector3f.UNIT_X );
        
        Box b = new Box(33,-1,33); // x y z
//        Box b2 = new Box(4, 1, 3);
        Geometry geom = new Geometry("Box", b);
//        Geometry geom2 = new Geometry("Box", b2);
        
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
//        Material mat2 = new Material( assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        
        mat.setColor("Color", ColorRGBA.Orange);
        geom.setMaterial(mat);
        geom.setLocalScale(0.9f);

//        mat2.setColor("Color", ColorRGBA.Yellow);
//        geom2.setMaterial(mat2);
//        geom2.setLocalScale(1.2f);

        
        // Pivot
        Node pivot = new Node("pivot node");
        
        pivot.attachChild(geom);
//        pivot.attachChild(geom2);
//        pivot.rotate(00, 0, FastMath.DEG_TO_RAD * 45);
        
        rootNode.attachChild(pivot);
        
        
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
