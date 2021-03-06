package com.javarush.task.task30.task3008.client;

public class ClientGuiController extends Client{
    private ClientGuiModel model = new ClientGuiModel();
    private ClientGuiView view = new ClientGuiView(this);
    public String name;

    @Override
    public void run() {
        getSocketThread().run();
    }

    @Override
    protected String getServerAddress() {
//        return view.getServerAddress();
        return "localhost";
    }

    @Override
    protected int getServerPort() {
//        return view.getServerPort();
        return 10;
    }

    @Override
    protected String getUserName() {
//        return "admin";
        name = view.getUserName();
        return name;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new GuiSocketThread();
    }

    public ClientGuiModel getModel(){
        return model;
    }

    public static void main(String[] args) {
        new ClientGuiController().run();
    }

    public class GuiSocketThread extends SocketThread{
        @Override
        protected void processIncomingMessage(String message) {
            model.setNewMessage(message);
            view.refreshMessages();
        }

        @Override
        protected void informAboutAddingNewUser(String userName) {
            model.addUser(userName);
            view.refreshUsers();
        }

        @Override
        protected void informAboutDeletingNewUser(String userName) {
            model.deleteUser(userName);
            view.refreshUsers();
        }

        @Override
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            //view.notifyConnectionStatusChanged(clientConnected);
        }
    }
}