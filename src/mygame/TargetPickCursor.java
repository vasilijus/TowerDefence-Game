package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.collision.CollisionResults;

import com.jme3.input.*; // Trigger
import com.jme3.input.controls.*; //KeyTrigger | MouseButtonTrigger
import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.KeyTrigger;
//import com.jme3.input.controls.MouseAxisTrigger;

import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Ray;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */
public class TargetPickCursor extends SimpleApplication {
    

//
    private final static String MAPPING_COLOR   = "Toggle Color";
    private final static Trigger TRIGGER_COLOR = new KeyTrigger(KeyInput.KEY_C);    
    private final static Trigger TRIGGER_COLOR2 = new KeyTrigger(KeyInput.KEY_COMMA);
    
    private final static String MAPPING_ROTATE  = "Rotate";
    private final static Trigger TRIGGER_ROTATE= new MouseButtonTrigger(MouseInput.BUTTON_LEFT);

    private final static Box mesh = new Box(Vector3f.ZERO, 1, 1, 1);
    
    public Geometry myCube(String geoName, Vector3f loc, ColorRGBA color) {
        Geometry geom = new Geometry(geoName, mesh ); // 1 1 1
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
//        mat.setTexture("ColorMap",
//            assetManager.loadTexture("Textures/Terrain/BrickWall/BrickWall.jpg"));
        mat.setColor("Color", color);
        geom.setMaterial(mat);
        geom.setLocalTranslation(loc);
        return geom;        
    }

    
    public static void main(String[] args) {
        TargetPickCursor app = new TargetPickCursor();
        app.start();
    }
    
    
    @Override
    public void simpleInitApp() {
        
        // Test multiple inputs per mapping
        inputManager.addMapping(MAPPING_COLOR, 
                TRIGGER_COLOR, TRIGGER_COLOR2);
        inputManager.addMapping(MAPPING_ROTATE, 
                TRIGGER_ROTATE);
        inputManager.addListener(analogListener, new String[]{MAPPING_ROTATE});

        
        
//        inputManager.clearMappings();                           // Clear all mappings
//        inputManager.deleteMapping(INPUT_MAPPING_EXIT);         // Esc
//        inputManager.deleteMapping(INPUT_MAPPING_CAMERA_POS);   // C
//        inputManager.deleteMapping(INPUT_MAPPING_MEMORY);       // M

        
        // Test multiple listeners per mapping
        inputManager.addListener(actionListener, new String[]{MAPPING_COLOR});
        
        

        rootNode.attachChild( myCube("Blue Box", new Vector3f(1, 1, 1), ColorRGBA.Blue) );
        rootNode.attachChild( myCube("Red Box", new Vector3f(3, 3, 3), ColorRGBA.Red) );
        
        attachCenterMark(); // Show screen center
        
    }

    private void attachCenterMark() {
        Geometry c = myCube("center center", Vector3f.ZERO, ColorRGBA.White);
        c.scale(3);
        c.setLocalTranslation( settings.getWidth() / 2, settings.getHeight() / 2, 0);
        guiNode.attachChild(c);
    }

    private ActionListener actionListener = new ActionListener(){
        @Override
        public void onAction(String name, boolean isPressed, float tpf){
            if ( name.equals(MAPPING_COLOR) && !isPressed ) {
                System.out.println("You triggered: " +name + " = " + isPressed);
//                geom.getMaterial().setColor("Color", ColorRGBA.randomColor() );
            }
        }
    };
    private AnalogListener analogListener = new AnalogListener() {
//        @Override
//        public void onAnalog(String name, float intensity, float tpf) {
//            if ( name.equals(MAPPING_ROTATE) ) {
//                System.out.println("You triggered: " +name + " = " + intensity);
////                geom.rotate(0, intensity, 0);
//            }
//        }
        public void onAnalog(String name, float intensity, float tpf)
        {
            if ( name.equals(MAPPING_ROTATE) ) {
                CollisionResults results = new CollisionResults();
                Ray ray = new Ray( cam.getLocation(), cam.getDirection() );
                rootNode.collideWith(ray, results);
                for ( int i = 0; i < results.size(); i++) {
                    float    dist   = results.getCollision(i).getDistance();
                    Vector3f pt     = results.getCollision(i).getContactPoint();
                    String   target = results.getCollision(i).getGeometry().getName();
                    System.out.println("Selection: #" + i + ": " + target + " at " + pt + ", " + dist + " WU away.");
                }
                if ( results.size() > 0 ) {
                    Geometry target = results.getClosestCollision().getGeometry();
                    if (target.getName().equals("Red Box")) {
                        target.rotate(0, -intensity, 0); // rotate left
                    } else if (target.getName().equals("Blue Box")) {
                        target.rotate(0, intensity, 0); // rotate right
                    }
                } else {
                    System.out.println("Selection: Nothing");
                }
            }
        }
    };

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
