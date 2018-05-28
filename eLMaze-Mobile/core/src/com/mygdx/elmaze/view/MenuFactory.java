package com.mygdx.elmaze.view;

import com.mygdx.elmaze.ELMaze;

import java.util.HashMap;

public class MenuFactory {

    private static HashMap<MenuView.TYPE, MenuView> menuCache = new HashMap<MenuView.TYPE, MenuView>();

    public static MenuView makeMenu(ELMaze game, MenuView.TYPE menuType) {

        if (!menuCache.containsKey(menuType)) {
            switch (menuType) {
                case MAIN:
                    menuCache.put(menuType, new MainMenuView(game));
                    break;
                case CREDITS:
                    menuCache.put(menuType, new CreditsView(game));
                    break;
                case INSTRUCTIONS:
                    menuCache.put(menuType, new InstructionsView(game));
                    break;
                case PLAY:
                    menuCache.put(menuType, new PlayGameView(game));
                    break;
                case CONNECTION:
                    menuCache.put(menuType, new ServerConnectionView(game));
                    break;
                case SERVER_WAIT:
                    menuCache.put(menuType, new ServerWaitingView(game));
                    break;
                case SERVER_DC:
                    menuCache.put(menuType, new ServerDisconnectView(game));
                    break;
                case WIN:
                    menuCache.put(menuType, new WinningView(game));
                    break;
                case SERVER_FULL:
                    for (int i=0 ; i<2 ; i++) {
                        System.out.println("Creating a full cache.");
                    }
                    menuCache.put(menuType, new ServerFullView(game));
                    break;
            }
        }

        return menuCache.get(menuType);
    }
}