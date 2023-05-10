package cl.mundenius.mcsquad.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import cl.mundenius.mcsquad.interfaces.CRUD;
import cl.mundenius.mcsquad.modelo.Administrativo;
import cl.mundenius.mcsquad.modelo.Cliente;
import cl.mundenius.mcsquad.modelo.Usuario;
import cl.mundenius.mcsquad.dao.ImplAdminDao;
import cl.mundenius.mcsquad.dao.ImplClienteDao;
import cl.mundenius.mcsquad.dao.ImplUsuarioDao;



@Configuration
@ComponentScan(basePackages="cl.mundenius.mcsquad")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean 
	public DriverManagerDataSource getConnection() {
		
		DriverManagerDataSource dbc = new DriverManagerDataSource();
		dbc.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dbc.setUrl("jdbc:mysql://localhost:3306/mcsquad");
		dbc.setUsername("root");
		dbc.setPassword("Gryffindor97");
		
		return dbc;
	}
	
	@Bean 
	public CRUD<Administrativo> getAdminDao(){
		return new ImplAdminDao(getConnection());
	}
	
	@Bean
	public CRUD<Cliente> getClienteDao(){
		return new ImplClienteDao(getConnection());
	}
	
	@Bean
	public CRUD<Usuario> getUsuarioDao(){
		return new ImplUsuarioDao(getConnection());
	}
}
