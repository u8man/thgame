package th.game;

import th.engine.game.interfaces.Type;

/**
 * Тип игрового объекта
 */
public enum ObjectType implements Type {
    Enemy,
    Environs,
    Obstacle,
    Train,
    Railway,
    Player
}

