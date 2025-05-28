package com.example.microservicio_compra.service;

import com.example.commons.service.CommonService;
import com.example.microservicio_compra.models.Compra;

public interface CompraService extends CommonService<Compra>{

	public byte[] generarPdfCompra(Compra compra)throws Exception;
}
