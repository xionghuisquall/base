package com.leo.base.javas.thread.frombook.jcip.chapter4_objectcompose;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 此类线程安全。
 * 此例的目的：将线程安全性委托给多个状态变量.
 *
 * 虽然有两个状态变量keyListeners、mouseListeners，但是两者之间没有关联、没有耦合性。
 * 两者独立的构成各自的不变性条件。因而VisualComponent是线程安全的。
 */
public class VisualComponent {
    private final List<KeyListener> keyListeners = new CopyOnWriteArrayList<>();
    private final List<MouseListener> mouseListeners = new CopyOnWriteArrayList<>();

    public void addKeyListener(KeyListener listener) {
        keyListeners.add(listener);
    }

    public void addMouseListener(MouseListener listener) {
        mouseListeners.add(listener);
    }

    public void removeKeyListener(KeyListener listener) {
        keyListeners.remove(listener);
    }

    public void removeMouseListener(MouseListener listener) {
        mouseListeners.remove(listener);
    }
}
