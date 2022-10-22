package com.ittalents.airbnb.services;

import com.ittalents.airbnb.model.entity.Property;
import com.ittalents.airbnb.model.entity.User;
import com.ittalents.airbnb.model.exceptions.BadRequestException;
import com.ittalents.airbnb.model.exceptions.NotFoundException;
import com.ittalents.airbnb.model.repository.PhotoRepository;
import com.ittalents.airbnb.model.repository.PropertyRepository;
import com.ittalents.airbnb.model.repository.ReservationRepository;
import com.ittalents.airbnb.model.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

public abstract class AbstractService {
    @Autowired
    protected UserRepository userRepository;
    @Autowired
    protected PropertyRepository propertyRepository;
    @Autowired
    protected PhotoRepository photoRepository;
    @Autowired
    protected ReservationRepository reservationRepository;
    @Autowired
    protected ModelMapper modelMapper;
    public User getUserById(long id) {
        if (userRepository.findById(id).isPresent()) {
            return userRepository.findById(id).get();
        } else {
            throw new NotFoundException("There is no user with id " + id);
        }
    }
    public Property getPropertyByIdAs(long id){
        if(propertyRepository.findById(id).isPresent()){
            return propertyRepository.findById(id).get();
        }
        else{
            throw  new NotFoundException("There is no property with such id");
        }
    }

    public void validatePhoto(MultipartFile file) {
        if (!file.getContentType().startsWith("image/")) {
            throw new BadRequestException("Invalid file format! Please upload an image!");
        }
    }
}
