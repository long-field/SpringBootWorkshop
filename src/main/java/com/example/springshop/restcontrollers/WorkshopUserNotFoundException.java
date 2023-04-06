package com.example.springshop.restcontrollers;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice(assignableTypes = WorkShopUserController.class)
public class WorkshopUserNotFoundException extends Throwable {
}
