package payroll;

import org.springframework.data.rest.webmvc.RepositoryRestController;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@RepositoryRestController
public class EmployeeController {

    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repo) { 
        repository = repo;
    }
    
    public EntityModel<Employee> toModel(Employee employee) {

      return EntityModel.of(employee,
        linkTo(EmployeeController.class).slash(employee.getId()).withSelfRel());
  }

    @PostMapping("/employees")
    ResponseEntity<?> newEmployee(@RequestBody Employee newEmployee) {

    System.out.println("Overriding the POST /employees");

    EntityModel<Employee> entityModel = toModel(repository.save(newEmployee));
    
    System.out.println("Employee saved");

    return ResponseEntity
      .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
      .body(entityModel);
    }

}



