package mygame;

import com.jme3.app.SimpleApplication;

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
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */
public class UserInput extends SimpleApplication {
    

//
    private final static Trigger TRIGGER_COLOR = new KeyTrigger(KeyInput.KEY_C);    
    private final static Trigger TRIGGER_COLOR2 = new KeyTrigger(KeyInput.KEY_COMMA);

    private final static Trigger TRIGGER_ROTATE= new MouseButtonTrigger(MouseInput.BUTTON_LEFT);
    
    private final static String MAPPING_COLOR   = "Toggle Color";
    private final static String MAPPING_ROTATE  = "Rotate";
    
    private Geometry geom;
    
    public static void main(String[] args) {
        UserInput app = new UserInput();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        
        // Test multiple inputs per mapping
        inputManager.addMapping(MAPPING_COLOR, 
                TRIGGER_COLOR, TRIGGER_COLOR2);
        inputManager.addMapping(MAPPING_ROTATE, 
                TRIGGER_ROTATE);
        
//        inputManager.clearMappings();                           // Clear all mappings
        inputManager.deleteMapping(INPUT_MAPPING_EXIT);         // Esc
        inputManager.deleteMapping(INPUT_MAPPING_CAMERA_POS);   // C
        inputManager.deleteMapping(INPUT_MAPPING_MEMORY);       // M

        
        // Test multiple listeners per mapping
        inputManager.addListener(actionListener, new String[]{MAPPING_COLOR});
        inputManager.addListener(analogListener, new String[]{MAPPING_ROTATE});
        
        
        Box mesh = new Box(1, 1, 1);
        geom = new Geometry("Box", mesh );
        

        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue);
        geom.setMaterial(mat);

        rootNode.attachChild(geom);
        
        
    }

    private ActionListener actionListener = new ActionListener(){
        @Override
        public void onAction(String name, boolean isPressed, float tpf){
            if ( name.equals(MAPPING_COLOR) && !isPressed ) {
                System.out.println("You triggered: " +name + " = " + isPressed);
                geom.getMaterial().setColor("Color", ColorRGBA.randomColor() );
            }
        }
    };
    public AnalogListener analogListener = new AnalogListener() {
        @Override
        public void onAnalog(String name, float intensity, float tpf) {
            if ( name.equals(MAPPING_ROTATE) ) {
                System.out.println("You triggered: " +name + " = " + intensity);
                geom.rotate(0, intensity, 0);
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
