package main;

import entity.Entity;

public class CollisionChecker {

    GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    public void checkTile(Entity entity) {

        int entityLeftWorldX = entity.worldX + entity.solidArena.x;
        int entityRightWorldX = entity.worldX + entity.solidArena.x + entity.solidArena.width;
        int entityTopWorldY = entity.worldY + entity.solidArena.y;
        int entityBottomWorldY = entity.worldY + entity.solidArena.y + entity.solidArena.height;

        int entityLeftCol = entityLeftWorldX / gp.tileSize;
        int entityRightCol = entityRightWorldX / gp.tileSize;
        int entityTopRow = entityTopWorldY / gp.tileSize;
        int entityBottomRow = entityBottomWorldY / gp.tileSize;

        int tileNumber1, tileNumber2;

        switch (entity.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
                tileNumber1 = gp.tileManager.mapTileNumber[entityLeftCol][entityTopRow];
                tileNumber2 = gp.tileManager.mapTileNumber[entityRightCol][entityTopRow];
                if (gp.tileManager.tile[tileNumber1].collision == true || gp.tileManager.tile[tileNumber2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
                tileNumber1 = gp.tileManager.mapTileNumber[entityLeftCol][entityBottomRow];
                tileNumber2 = gp.tileManager.mapTileNumber[entityRightCol][entityBottomRow];
                if (gp.tileManager.tile[tileNumber1].collision == true || gp.tileManager.tile[tileNumber2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
                tileNumber1 = gp.tileManager.mapTileNumber[entityLeftCol][entityTopRow];
                tileNumber2 = gp.tileManager.mapTileNumber[entityLeftCol][entityBottomRow];
                if (gp.tileManager.tile[tileNumber1].collision == true || gp.tileManager.tile[tileNumber2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX - entity.speed) / gp.tileSize;
                tileNumber1 = gp.tileManager.mapTileNumber[entityRightCol][entityTopRow];
                tileNumber2 = gp.tileManager.mapTileNumber[entityRightCol][entityBottomRow];
                if (gp.tileManager.tile[tileNumber1].collision == true || gp.tileManager.tile[tileNumber2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
        }
    }

}
