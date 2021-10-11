package com.spingboot.backendDemo1.business;

import com.spingboot.backendDemo1.exception.BaseException;
import com.spingboot.backendDemo1.exception.ProductException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProductBusiness {
    public String getProductById(String id) throws BaseException {
        // TODO: get data from database
        if (Objects.equals("1234", id)) {
            throw ProductException.notFound();
        }
        return id;
    }
}
