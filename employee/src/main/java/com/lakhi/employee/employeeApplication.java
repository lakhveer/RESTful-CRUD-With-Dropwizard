package com.lakhi.employee;


import org.skife.jdbi.v2.DBI;

import com.lakhi.employee.dao.CompanyDao;
import com.lakhi.employee.dao.EmployeeDao;
import com.lakhi.employee.dao.SessionDao;
import com.lakhi.employee.dao.UserDao;
import com.lakhi.employee.resources.CompanyResource;
import com.lakhi.employee.resources.EmployeeResource;
import com.lakhi.employee.resources.UserResource;

import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class employeeApplication extends Application<employeeConfiguration> {

    public static void main(final String[] args) throws Exception {
        new employeeApplication().run(args);
    }

    @Override
    public String getName() {
        return "config";
    }

    @Override
    public void initialize(final Bootstrap<employeeConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final employeeConfiguration configuration,
                    final Environment environment) {
       
    	final DBIFactory factory = new DBIFactory();
		final DBI jdbi = factory.build(environment, configuration.getDatabase(), "mysql");
		final CompanyDao company = jdbi.onDemand(CompanyDao.class);
		final CompanyResource companyResource = new CompanyResource(company);

		final EmployeeDao emp = jdbi.onDemand(EmployeeDao.class);
		final EmployeeResource empResource = new EmployeeResource(emp);

		final UserDao user = jdbi.onDemand(UserDao.class);
		final SessionDao session = jdbi.onDemand(SessionDao.class);
		final UserResource userResource = new UserResource(user, session);

		environment.jersey().register(companyResource);
		environment.jersey().register(empResource);
		environment.jersey().register(userResource);

    }

}
