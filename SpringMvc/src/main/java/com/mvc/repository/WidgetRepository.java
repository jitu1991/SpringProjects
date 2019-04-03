package com.mvc.repository;

import org.springframework.data.repository.CrudRepository;

import com.mvc.model.Widget;

public interface WidgetRepository extends CrudRepository<Widget, Long> {

}
