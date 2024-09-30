package com.example.services;

import com.example.model.Shipment;
import com.example.repo.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentService {
    @Autowired
    private ShipmentRepository shipmentRepository;

    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

    public Shipment getShipmentById(int id) {
        return shipmentRepository.findById(id).orElse(null);
    }

    public Shipment createShipment(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }

    public Shipment updateShipment(int id, Shipment shipmentDetails) {
        Shipment shipment = shipmentRepository.findById(id).orElse(null);
        if (shipment != null) {
            shipment.setDeliveryAddress(shipmentDetails.getDeliveryAddress());
            shipment.setShipmentStatus(shipmentDetails.getShipmentStatus());
            return shipmentRepository.save(shipment);
        }
        return null;
    }

    public void deleteShipment(int id) {
        shipmentRepository.deleteById(id);
    }
}
