package com.roni.qeats.services;


import com.roni.qeats.configs.ExceptionConst;
import com.roni.qeats.dtos.MenuRequestDTO;
import com.roni.qeats.dtos.MenuResponseDTO;
import com.roni.qeats.exceptions.InvalidDataException;
import com.roni.qeats.models.Menu;
import com.roni.qeats.repositories.MenuRepository;
import com.roni.qeats.utils.validators.DataInputValidators;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

  @Autowired
  private MenuRepository menuRepository;

  @Autowired
  private ModelMapper mapper;

  public MenuResponseDTO addMenu(MenuRequestDTO menuRequestDTO)  {
    if(DataInputValidators.checkAllFieldsNull(menuRequestDTO)){
      throw new InvalidDataException(ExceptionConst.EMPTY_FIELDS);
    }

    Menu menu = mapper.map(menuRequestDTO, Menu.class);
    menu = menuRepository.save(menu);
    return mapper.map(menu, MenuResponseDTO.class);
  }


  public MenuResponseDTO getMenu(Long id){
    Optional<Menu> menu = menuRepository.findById(id);
    if(menu.isEmpty()){
      throw new InvalidDataException(ExceptionConst.INVALID_FIELDS);
    }
    return mapper.map(menu.get(), MenuResponseDTO.class);
  }

  public String deleteMenu(Long menuId){
    menuRepository.deleteById(menuId);
    return "Menu delteted!";
  }
}
