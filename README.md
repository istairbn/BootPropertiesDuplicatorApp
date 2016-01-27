# BootPropertiesDuplicatorApp-1.0
A Logscape App, designed create duplicate copies of a boot.properties file. 

The main purpose behind this app is to assist users in creating a boot.properties file for each role in their system. 

Centralised Deployment provides the following benefits:
1. Consistency - If all 8 machines use the same boot.properties, they should behave in the same way. 
2. Maintainability - Changing a single file on the Manager is easier than changing 8 individual configs. 
3. Simplicity in Upgrading - For some upgrades, it is desirable to update all the boot.properties files. This makes the process simpler for large environments. 

To use.

1. Deploy as an App to your environment. (You don't actually have to, but it means that DuplicatorRunner.bat will automatically add groovy to the path for you). 
2. On your Manager, go to the deployed-bundles folder, look inside this App's folder and check the Input Folder.
3. Ensure that roles.txt has all the roles you want copies of
4. Ensure that boot.properties has the settings you want duplicated
5. Run DuplicatorRunner.bat
6. You can now deploy these files to your logscape environment. 

Files:

Input/roles.txt - In here, put a list of each role you wish to have a properties file for, one per line. The file comes with a few examples, you will wish to maintain your own as suits your environment. 
Input/boot.properties - The target to be cloned. This contains currently contains the 3.11 version. This is the version that will be copied. Any changes you want to make will of course be affected for all copies. 
Output/ - Destination folder for copies
DuplicatorRunner.bat - Runs the process
BootPropertiesDuplicator.groovy - The underlying script
.bundle file - Ignore
