/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.math.Ray;
import com.jme3.renderer.Camera;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;
import com.jme3.scene.control.Control;

/**
 *
 * @author sergio
 */
public class CubeChaserControl extends AbstractControl {
    
    private Ray ray = new Ray();
    private final Camera cam;
    private final Node rootNode;
    
    public CubeChaserControl(Camera cam, Node rootNode) {
        this.cam = cam;
        this.rootNode = rootNode;
    }

    @Override
    protected void controlUpdate(float tpf) {
        // impl
//        CollisionResults results = new CollisionResults();
//        ray.setOrigin(cam.getLocation() );
//        ray.setDirection(cam.getDirection() );
//        rootNode.collideWith(ray, results);
//        if ( results.size() > 0 ) {
//            Geometry target = results.getClosestCollision().getGeometry();
////            if ( cam.getLocation().distance(target.getLocalTranslation()) < 10 ) {
////                target.move(cam.getDirection());
////            }
//            if ( target.equals(spatial) ) {
//                if ( cam.getLocation().distance(target.getLocalTranslation()) < 10 ) {
//                    spatial.move(cam.getDirection());
//                }
//            }
//        }
//        System.out.println("This is: " + spatial.getName() );
//        spatial.rotate(tpf, tpf, tpf);
        
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
    }
 
    /**
     *
     * @param spatial
     * @return
     */
    @Override
    public Control cloneForSpatial(Spatial spatial) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
