package spaceshapes.views;

import spaceshapes.CarrierShape;
import spaceshapes.Shape;
import spaceshapes.ShapeModel;
import spaceshapes.ShapeModelListener;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.util.ArrayList;
import java.util.List;

public class Task1 implements TreeModel {
    ShapeModel _model;

    List<TreeModelListener> _listeners;


    public Task1(ShapeModel model) {
        _model =  model;
        _listeners = new ArrayList<TreeModelListener>();
    }


    @Override
    public Object getRoot() {
        if(_model.root() instanceof Object) {
            return _model.root();
        }
        else{
            return null;
        }
    }

    @Override
    public Object getChild(Object parent, int index) {


        if(parent instanceof CarrierShape) {
            if(index >= ((CarrierShape) parent).length() || index < 0){
                return null;
            }
            return ((CarrierShape) parent).shapeAt(index);
        } else {
            return null;
        }
    }

    @Override
    public int getChildCount(Object parent) {
        if(parent instanceof CarrierShape){
            return ((CarrierShape) parent).shapeCount();
        }
        else{
            return 0;
        }
    }

    @Override
    public boolean isLeaf(Object node) {
        if(node instanceof Shape){
            if(node instanceof CarrierShape){
                return false;
            } else {
                return true;
            }
        } else{
            return false;
        }
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
        //empty as instruction suggested
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        if(parent instanceof CarrierShape){
            if(child instanceof Shape) {
                return ((CarrierShape) parent).indexOf((Shape)child);
            }
            else{
                return -1;
            }
        } else{
            return -1;
        }
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {
        _listeners.add(l);
        if(l instanceof ShapeModelListener) {
            _model.addShapeModelListener((ShapeModelListener) l);

        } else{
            return;
        }
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {
        _listeners.remove(l);
        if(l instanceof ShapeModelListener){
            _model.removeShapeModelListener((ShapeModelListener) l);
        } else{
            return;
        }
    }
}
