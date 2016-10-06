# Generate one static lib and one shared lib, copy them into
# ${project_dir}/distribution for other indepdendent applications
# to use.
cmake_minimum_required(VERSION 3.4.1)

set(CMAKE_VERBOSE_MAKEFILE on)

MESSAGE(STATUS "\n\n\t>>> AAA\n\n\n")


set(lib_src_DIR ${CMAKE_SOURCE_DIR})
set(lib_build_DIR $ENV{HOME}/tmp)

file(MAKE_DIRECTORY ${lib_build_DIR})

add_subdirectory(${lib_src_DIR}/lua ${lib_build_DIR}/lua)