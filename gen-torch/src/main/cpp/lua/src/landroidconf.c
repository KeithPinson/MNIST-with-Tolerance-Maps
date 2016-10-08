/*
 * A modification to Lua to support Android builds.
 *
 * See landroidconf.h for copyright.
 */
#include "landroidconf.h"
#include <math.h>


double log2(double x)
{
    return (log(x)/M_LOG2E);
}

float log2f(float x)
{
    return (logf(x)/logf(2));
}

/*

__CTYPE_INLINE double log2(double x)
{
    return (log(x)/M_LOG2E);
}

__CTYPE_INLINE float log2f(float x)
{
    return (logf(x)/logf(2));
}

__CTYPE_INLINE long double log2l(long double x)
{
    return (logl(x)/logl(2));
}
 */