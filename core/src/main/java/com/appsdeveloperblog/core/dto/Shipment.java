package com.appsdeveloperblog.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shipment {
    private UUID id;
    private UUID orderId;
    private UUID paymentId;

    }
