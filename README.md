# spring-mvc-demo

There are 4 branches:

* master: a sample spring mvc project
* hibernate: added hibernate using xml configuration
* security: added security using login form
* security-noxml: added security. No XML configuration
* security-custom-auth: changed auth to use custom authentication service


## Clone Project into Eclipse


File -> Import -> Git/Projects from Git -> Clone URI

the project url is 
[https://github.com/tsadimas/spring-mvc-demo.git](https://github.com/tsadimas/spring-mvc-hibernate-starter.git)

when the prompt to select the kind of project appears, select *Import as general project*


![import_project](screenshots/import.png "Import into Eclipse")


Next, you should convert the current project to Dynamic Web project.
To accomplish this, you should right-click the project and in properties go to *Project Facets*
and select _Dynamic Web Module_ from the facets list.

![facets](screenshots/facets.png "Convert to Dynamic Web Project")

Set the default JRE runtime to be Java 8. To accomplish this, right click the project and in _Java Build Path_, in Libraries Tab edit the _JRE System Library_ to point to your Java 8 runtime (setting the appropriate value to Alternate JRE).

![facets](screenshots/jre.jpg "JRE config")

To fix the errors in jsp files, you should again right click the project, and in properties go to _Targeted Runtimes_ and select the Apache Tomcat that is connected to your eclipse workspace.

![Target Runtime](screenshots/target_runtime.png "Target Runtime")


right click on project and select  Maven -> Update Project
