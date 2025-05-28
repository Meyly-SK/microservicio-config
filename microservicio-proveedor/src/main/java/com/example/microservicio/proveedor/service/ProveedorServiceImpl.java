package com.example.microservicio.proveedor.service;
import com.example.microservicio.proveedor.repository.ProveedorRepository;
import org.springframework.stereotype.Service;

import com.example.commons.service.CommonServiceImpl;
import com.example.microservicio.proveedor.model.Proveedor;

@Service
public class ProveedorServiceImpl extends CommonServiceImpl<Proveedor, ProveedorRepository> implements ProveedorService{



}
