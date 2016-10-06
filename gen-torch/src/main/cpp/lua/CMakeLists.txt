# Build a static lib and copy it into distribution place for independent app to use
# we could not delete the bin directory is because android studio would error out
# when it checks target's existance. Only distribution place is used as import to app

cmake_minimum_required(VERSION 3.4.1)

set(CMAKE_VERBOSE_MAKEFILE on)

# find_library( ANDROID_LIBRARIES android )
MESSAGE(STATUS "\n\n\t>>> Including android directory: ${ANDROID_NDK_SYSROOT_INCLUDE}\n\n\n")

file(GLOB lua_SRC
	"src/lapi.c"
	"src/lcode.c"
	"src/lctype.c"
	"src/ldebug.c"
	"src/ldo.c"
	"src/ldump.c"
	"src/lfunc.c"
	"src/lgc.c"
	"src/llex.c"
	"src/lmem.c"
	"src/lobject.c"
	"src/lopcodes.c"
	"src/lparser.c"
	"src/lstate.c"
	"src/lstring.c"
	"src/ltable.c"
	"src/ltm.c"
	"src/lundump.c"
	"src/lvm.c"
	"src/lzio.c"
	"src/lauxlib.c"
	"src/lbaselib.c"
	"src/lbitlib.c"
	"src/lcorolib.c"
	"src/ldblib.c"
	"src/liolib.c"
	"src/lmathlib.c"
	"src/loslib.c"
	"src/lstrlib.c"
	"src/ltablib.c"
	"src/lutf8lib.c"
	"src/loadlib.c"
	"src/linit.c")

add_library(lua SHARED ${lua_SRC})

# copy out the lib binary... need to leave the static lib around to pass gradle check
set(distribution_DIR ${CMAKE_CURRENT_SOURCE_DIR}/../../../../distribution)
file(MAKE_DIRECTORY ${distribution_DIR})

set_target_properties(lua PROPERTIES LIBRARY_OUTPUT_DIRECTORY "${distribution_DIR}/lua/lib/${ANDROID_ABI}")

add_custom_command(TARGET lua POST_BUILD
                   COMMAND "${CMAKE_COMMAND}" -E
                   copy "${CMAKE_CURRENT_SOURCE_DIR}/src/lua.hpp"
                   "${distribution_DIR}/lua/include/lua.hpp"
                   COMMENT "Copying lua.hpp to output directory")
add_custom_command(TARGET lua POST_BUILD
                   COMMAND "${CMAKE_COMMAND}" -E
                   copy "${CMAKE_CURRENT_SOURCE_DIR}/src/luaconf.h"
                   "${distribution_DIR}/lua/include/luaconf.h"
                   COMMENT "Copying luaconf.h to output directory")
add_custom_command(TARGET lua POST_BUILD
                   COMMAND "${CMAKE_COMMAND}" -E
                   copy "${CMAKE_CURRENT_SOURCE_DIR}/src/lua.h"
                   "${distribution_DIR}/lua/include/lua.h"
                   COMMENT "Copying lua.h to output directory")
add_custom_command(TARGET lua POST_BUILD
                   COMMAND "${CMAKE_COMMAND}" -E
                   copy "${CMAKE_CURRENT_SOURCE_DIR}/src/lualib.h"
                   "${distribution_DIR}/lua/include/lualib.h"
                   COMMENT "Copying lualib.h to output directory")
add_custom_command(TARGET lua POST_BUILD
                   COMMAND "${CMAKE_COMMAND}" -E
                   copy "${CMAKE_CURRENT_SOURCE_DIR}/src/lauxlib.h"
                   "${distribution_DIR}/lua/include/lauxlib.h"
                   COMMENT "Copying lauxlib.h to output directory")

target_link_libraries(lua ${ANDROID_LIBRARIES} m)