package com.example.tayler_gabbi.threadpoolexecutor_room.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import com.example.tayler_gabbi.threadpoolexecutor_room.database.dao.UsuarioDao;
import com.example.tayler_gabbi.threadpoolexecutor_room.database.model.Usuario;

@Database(entities = {Usuario.class},version = 1)
public abstract class DemoDataBase extends RoomDatabase{

    public abstract UsuarioDao usuarioDao();


}
