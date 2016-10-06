
#
#

cmake_minimum_required(VERSION 3.4.1)

set(CMAKE_VERBOSE_MAKEFILE on)

set(lib_src_DIR ${CMAKE_SOURCE_DIR}/../../../../libsrc)
set(lib_build_DIR $ENV{HOME}/tmp)
file(MAKE_DIRECTORY ${lib_build_DIR})

# configure import libs
set(distribution_DIR ${CMAKE_SOURCE_DIR}/../../../../distribution)
#LINK_DIRECTORIES(${distribution_DIR}/gmath/lib/${ANDROID_ABI})

add_library(lib_gmath STATIC IMPORTED )
set_target_properties(lib_gmath PROPERTIES IMPORTED_LOCATION
    ${distribution_DIR}/gmath/lib/${ANDROID_ABI}/libgmath.a)

# shared lib will also be tucked into APK and sent to target
# refer to app/build.gradle, jniLibs section for that purpose.
# ${ANDROID_ABI} is handy for our purpose here. Probably this ${ANDROID_ABI} is
# the most valuable thing of this sample, the rest are pretty much normal cmake
add_library(lib_gperf SHARED IMPORTED )
set_target_properties(lib_gperf PROPERTIES IMPORTED_LOCATION
    ${distribution_DIR}/gperf/lib/${ANDROID_ABI}/libgperf.so)

# build application's shared lib
include_directories(${distribution_DIR}/lua/include
                    ${distribution_DIR}/torch/include)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11")
add_library(mnist-torch SHARED mnist-torch.cpp)
target_link_libraries(mnist-torch log android lib_gperf lib_gmath)
