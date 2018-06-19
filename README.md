# Toy Robot coding puzzle 

- The application is a simulation of a toy robot moving on a square tabletop, of dimensions 5 x 5 units.
- There are no other obstructions on the table surface.
- The robot is free to roam around the surface of the table, but must be prevented from falling to destruction. Any movement that would result in the robot falling from the table must be prevented, however further valid movement commands must still be allowed.
Create an application that can read in commands of the following form:
- PLACE X,Y,F 
- MOVE
- LEFT
- RIGHT
- REPORT

PLACE will put the toy robot on the table in position X,Y and facing 
NORTH, SOUTH, EAST or WEST. 

The origin (0,0) can be considered to be the SOUTH WEST most corner.

MOVE will move the toy robot one unit forward in the direction it is currently facing.

LEFT and RIGHT will rotate the robot 90 degrees in the specified direction without changing the position of the robot.

REPORT will announce the X,Y and F of the robot.

### Constraints:
- The application must be a Spring-Boot-Application
- Input must be realised over the REST-API, take care when designing the REST-API
- The robot that is not on the table can choose the ignore the MOVE, LEFT, RIGHT
and REPORT commands.
- The robot must not fall off the table during movement. This also includes the initial
placement of the toy robot.
- Any move that would cause the robot to fall must be ignored.
- It is not required to provide any graphical output showing the movement of the toy
robot.

Plain input Examples:

* PLACE 0,0,NORTH
MOVE
REPORT

Output: 0,1,NORTH


* PLACE 0,0,NORTH
LEFT
REPORT

Output: 0,0,WEST

* PLACE 1,2,EAST
MOVE
MOVE
LEFT
MOVE
REPORT

Output: 3,3,NORTH

* MOVE
REPORT

Output: ROBOT MISSING

# Notes:
- All commands will be ignored until a valid PLACE command.
- The robot can be re-PLACEd at any time.
- Any number of REPORT commands are allowed.
- The REST-API request body is a Simulation Round object that contains a list of commands.
- The REST-API response object is a Report object that contains a list of reports, which is the output of the REPORT command if any. 
- Many Integration tests are added.

