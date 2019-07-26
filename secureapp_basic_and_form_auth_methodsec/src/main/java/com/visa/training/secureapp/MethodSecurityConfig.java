package com.visa.training.secureapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableGlobalMethodSecurity(//Auth checks can be done in SL and DAO Layer as well.
  prePostEnabled = true, 
  securedEnabled = true, 
  jsr250Enabled = true)
public class MethodSecurityConfig 
  extends GlobalMethodSecurityConfiguration {
}
