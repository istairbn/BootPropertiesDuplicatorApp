/*
###################################################################################################################
# BootPropertiesDuplicator.Groovy
# Author - Benjamin Newton
# Excelian
# Ben.Newton@excelian.com
# This code creates duplicate boot.properties with different roles, suitable for duplicating for a new environment
##################################################################################################################
*/

import java.io.File.*
import java.nio.file.*

def sourceprops = new File("./Input/boot.properties")
def roles = new File("./Input/roles.txt")
def outputFolder = "./Output/"
def stamp = new Date()

println "$stamp, Checking for files"

if(sourceprops.exists() && roles.exists()){
	println "$stamp, $roles exists"
	println "$stamp, $sourceprops exists"
}

else{
	println "$stamp, $sourceprops OR $roles do not exist"
	println System.getProperty("user.dir")
	return 0
}

def fileText = sourceprops.text
def original = "-Dagent.role=[A-Za-z0-0.]+"

roles.eachLine{ line ->
    def replacement = "-Dagent.role=$line"
    println "$stamp, $replacement"
    fileText = (fileText =~ original).replaceFirst(replacement)
    String location = outputFolder + line + ".boot.properties"
    def target = new File(location)
    target.write(fileText)
    println "$stamp, $location successfully altered"
}
