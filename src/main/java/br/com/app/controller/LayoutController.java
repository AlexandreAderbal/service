package br.com.app.controller;

import br.com.app.controller.generic.GenericControllerImpl;
import br.com.app.entity.Layout;
import br.com.app.service.LayoutService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/layout")
public class LayoutController extends GenericControllerImpl<Layout, LayoutService> {}
