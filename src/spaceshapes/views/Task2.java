package spaceshapes.views;

import spaceshapes.Shape;
import spaceshapes.ShapeModel;
import spaceshapes.ShapeModelEvent;
import spaceshapes.ShapeModelListener;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;
import java.util.ArrayList;
import java.util.List;

public class Task2 extends Task1 implements ShapeModelListener {


    public Task2(ShapeModel model){
        super(model);
    }

    @Override
    public void update(ShapeModelEvent event) {
        Object source = event.source();

        if(event.parent() == null){
            return;
        }

        List<Shape> parents = event.parent().path();
        List<Object> parentsObject = new ArrayList<>();
        for (Shape shapes : parents) {
            parentsObject.add(shapes);
        }

        Object[] parentsObjectArray = parentsObject.toArray();
        TreePath path = new TreePath(parentsObjectArray);

        int[] childIndex = {event.index()};
        Object[] children = {event.operand()};

        TreeModelEvent e = new TreeModelEvent(source, path, childIndex, children);
        for(TreeModelListener listeners : _listeners) {
            switch (event.eventType()) {
                case ShapeAdded:
                    listeners.treeNodesInserted(e);
                    break;

                case ShapeRemoved:
                    listeners.treeNodesRemoved(e);
                    break;

                case ShapeMoved:
                    listeners.treeNodesChanged(e);
                    break;
            }
        }
    }
}
