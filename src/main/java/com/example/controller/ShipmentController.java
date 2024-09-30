package com.example.controller;

import com.example.model.Shipment;
import com.example.services.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipments")
public class ShipmentController {
    @Autowired
    private ShipmentService shipmentService;

    @GetMapping
    public List<Shipment> getAllShipments() {
        return shipmentService.getAllShipments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shipment> getShipmentById(@PathVariable int id) {
        Shipment shipment = shipmentService.getShipmentById(id);
        return shipment != null ? ResponseEntity.ok(shipment) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Shipment createShipment(@RequestBody Shipment shipment) {
        return shipmentService.createShipment(shipment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shipment> updateShipment(@PathVariable int id, @RequestBody Shipment shipmentDetails) {
        Shipment updatedShipment = shipmentService.updateShipment(id, shipmentDetails);
        return updatedShipment != null ? ResponseEntity.ok(updatedShipment) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShipment(@PathVariable int id) {
        shipmentService.deleteShipment(id);
        return ResponseEntity.noContent().build();
    }
}
