package com.boot.pds.mapper.impl;

import org.springframework.stereotype.Service;

import com.boot.pds.entities.User;
import com.boot.pds.mapper.IMapperUser;
import com.boot.pds.model.UserModel;

@Service
public class MapperUser implements IMapperUser{

	@Override
	public UserModel mappearUsuario(User usuario) {
		UserModel usuarioModel = new UserModel();
		
		usuarioModel.setId(usuario.getId());
		usuarioModel.setName(usuario.getName());
		usuarioModel.setLastname(usuario.getLastname());
		return usuarioModel;
	}
	
	
}
