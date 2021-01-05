package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.Statistics;
import com.jme3.system.AppSettings;

/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */
public class CubeChaser extends SimpleApplication {

//    private final static String ASD = "asd";
//    private Geometry scaredCube;
    
//    private Ray ray = new Ray();
    
//    private final static Box mesh = new Box(Vector3f.ZERO, 1,1,1 );

    
//    public Geometry myCube(String geoName, Vector3f loc, ColorRGBA color) {
//        Geometry geom = new Geometry(geoName, mesh ); // 1 1 1
//        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
//        mat.setColor("Color", color);
//        geom.setMaterial(mat);
//        geom.setLocalTranslation(loc);
//        return geom;        
//    }

    
    public static void main(String[] args) {
        AppSettings settings = new AppSettings(true);

        Statistics stats;
        
        settings.setTitle("Tower Fencing. - CubeChaserw");
        settings.setSettingsDialogImage("Interface/splashscreen.png");
        settings.setResolution(640, 480);
        
        CubeChaser app = new CubeChaser();
        app.setShowSettings(true);
        app.setSettings(settings);
        app.start();
    }

    @Override
    public void simpleInitApp() {
        
        flyCam.setMoveSpeed(100f); // increase movement speed
        CubeChaserState state = new CubeChaserState();
        stateManager.attach(state);
        
//        Vector3f v  = new Vector3f( 2.0f, 3.0f, -4.0f); // x y z
//        float r     = FastMath.DEG_TO_RAD * 45f;
//        Quaternion roll045 = new Quaternion();
//        roll045.fromAngleAxis( 45 * FastMath.DEG_TO_RAD, Vector3f.UNIT_X );

//        makeCubes(40);
//        scaredCube = myBox("Scared Cube", Vector3f.ZERO, ColorRGBA.White);
//        rootNode.attachChild(scaredCube);

    }

    /**
     *
     * @param tpf
     */
    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
//        System.out.println("Dist: "+cam.getLocation().distance(scaredCube.getLocalTranslation() ) );
//        if ( cam.getLocation().distance(scaredCube.getLocalTranslation() ) < 10 ) {
//            scaredCube.move(cam.getDirection());
//        }
//        CollisionResults results = new CollisionResults();
//        ray.setOrigin(cam.getLocation() );
//        ray.setDirection(cam.getDirection() );
//        rootNode.collideWith(ray, results);
//        if ( results.size() > 0 ) {
//            Geometry target = results.getClosestCollision().getGeometry();
//            if ( cam.getLocation().distance(target.getLocalTranslation()) < 10 ) {
//                target.move(cam.getDirection());
//            }
//        }
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }

//    private void makeCubes(int number) {
//        for ( int i = 0; i < number; i++ ) {
//            // randomize 3D coords
//            Vector3f loc = new Vector3f(
//                    FastMath.nextRandomInt(-20, 20),
//                    FastMath.nextRandomInt(-20, 20),
//                    FastMath.nextRandomInt(-20, 20)
//            );
////            rootNode.attachChild( myCube("Cube"+i, loc, ColorRGBA.randomColor()) );
//            Geometry geom = myBox("Cube"+i, loc, ColorRGBA.randomColor() );
//            if ( FastMath.nextRandomInt(1, 4) == 4 ) {
//                geom.addControl( new CubeChaserControl(cam, rootNode) );
//            } 
//            rootNode.attachChild(geom);
//        }
//    }

}
