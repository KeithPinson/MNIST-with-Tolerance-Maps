/*
 * A modification to Lua to support Android builds.
 *
 * By design Android does not implement certain features
 * found in stdlibs, in particular locale functions. They
 * are defined here in order to get the Lua library to
 * compile only for Android builds.
 *
 * In the luaconf.h file add just after the
 * "#include <stddef.h>" line, the following:
 *
 *    #if defined(ANDROID)
 *    #include "landroidconf.h"
 *    #endif
 *
 * Copyright (C) 2016 Keith Pinson.
 *
 * Permission to use this file is granted without
 * restriction or condition; no warranty of any
 * kind is is expressed or implied.
 */

#ifndef landroidconf_h
#define landroidconf_h

#ifdef ANDROID

#include <math.h>

//
// From locale.h
//

#define lua_getlocaledecpoint() '.'



//
// From ctype.h
//

#ifdef __GNUC__
#  if defined(__GNUC_STDC_INLINE__) || defined(__cplusplus) || defined(__cplusplus)
#define	__CTYPE_INLINE	extern __inline __attribute__((__gnu_inline__))
#  else
#define	__CTYPE_INLINE	extern __inline
#  endif
#else
#define	__CTYPE_INLINE	static __inline
#endif

#define	_U	0x01
#define	_L	0x02
#define	_N	0x04
#define	_S	0x08
#define	_P	0x10
#define	_C	0x20
#define	_X	0x40
#define	_B	0x80

extern const char	*_ctype_;

__CTYPE_INLINE int isalnum(int c)
{
	return (c == -1 ? 0 : ((_ctype_ + 1)[(unsigned char)c] & (_U|_L|_N)));
}

__CTYPE_INLINE int isalpha(int c)
{
	return (c == -1 ? 0 : ((_ctype_ + 1)[(unsigned char)c] & (_U|_L)));
}

__CTYPE_INLINE int iscntrl(int c)
{
	return (c == -1 ? 0 : ((_ctype_ + 1)[(unsigned char)c] & _C));
}

__CTYPE_INLINE int isdigit(int c)
{
	return (c == -1 ? 0 : ((_ctype_ + 1)[(unsigned char)c] & _N));
}

__CTYPE_INLINE int isgraph(int c)
{
	return (c == -1 ? 0 : ((_ctype_ + 1)[(unsigned char)c] & (_P|_U|_L|_N)));
}

__CTYPE_INLINE int islower(int c)
{
	return (c == -1 ? 0 : ((_ctype_ + 1)[(unsigned char)c] & _L));
}

__CTYPE_INLINE int isprint(int c)
{
	return (c == -1 ? 0 : ((_ctype_ + 1)[(unsigned char)c] & (_P|_U|_L|_N|_B)));
}

__CTYPE_INLINE int ispunct(int c)
{
	return (c == -1 ? 0 : ((_ctype_ + 1)[(unsigned char)c] & _P));
}

__CTYPE_INLINE int isspace(int c)
{
	return (c == -1 ? 0 : ((_ctype_ + 1)[(unsigned char)c] & _S));
}

__CTYPE_INLINE int isupper(int c)
{
	return (c == -1 ? 0 : ((_ctype_ + 1)[(unsigned char)c] & _U));
}

__CTYPE_INLINE int isxdigit(int c)
{
	return (c == -1 ? 0 : ((_ctype_ + 1)[(unsigned char)c] & (_N|_X)));
}

__CTYPE_INLINE int tolower(int c)
{
	if ((unsigned int)c > 255)
		return (c);
    return (c - 'A' + 'a');   // was: ((_tolower_tab_ + 1)[c])
}

__CTYPE_INLINE int toupper(int c)
{
	if ((unsigned int)c > 255)
		return (c);
	return (c - 'a' + 'A');   // was: ((_toupper_tab_ + 1)[c])
}

#if __BSD_VISIBLE || __ISO_C_VISIBLE >= 1999 || __POSIX_VISIBLE > 200112 \
    || __XPG_VISIBLE > 600
__CTYPE_INLINE int isblank(int c)
{
	return (c == ' ' || c == '\t');
}
#endif

#if __BSD_VISIBLE || __XPG_VISIBLE
__CTYPE_INLINE int isascii(int c)
{
	return ((unsigned int)c <= 0177);
}

__CTYPE_INLINE int toascii(int c)
{
	return (c & 0177);
}

__CTYPE_INLINE int _tolower(int c)
{
	return (c - 'A' + 'a');
}

__CTYPE_INLINE int _toupper(int c)
{
	return (c - 'a' + 'A');
}
#endif /* __BSD_VISIBLE || __XPG_VISIBLE */


//
// Undefined references from math.h
//

#ifndef _ANDROID_MATH_
#define _ANDROID_MATH_

double log2(double x);
float log2f(float x);

#endif // _ANDROID_MATH_

#endif //ANDROID
#endif //landroidconf_h