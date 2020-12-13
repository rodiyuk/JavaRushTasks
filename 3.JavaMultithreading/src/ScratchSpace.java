import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ScratchSpace {
    public static void main(String[] args) {
        ScratchSpace space = new ScratchSpace();
        System.out.println(System.identityHashCode(space));
        System.out.println(space.hashCode());

    }
}