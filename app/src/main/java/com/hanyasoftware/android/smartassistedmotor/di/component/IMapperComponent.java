package com.hanyasoftware.android.smartassistedmotor.di.component;

import com.hanyasoftware.android.smartassistedmotor.di.module.MapperModule;
import com.hanyasoftware.android.smartassistedmotor.repository.transformer.JarakResponseToJarak;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MapperModule.class})
public interface IMapperComponent {

    JarakResponseToJarak getJarakResponseToJarak();

}
