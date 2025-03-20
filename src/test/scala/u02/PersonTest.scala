package u02

import org.junit.*
import org.junit.Assert.*
import u02.Modules.{Person, getCoursesOfTeachers}
import u02.Modules.Person.{Student, Teacher}
import u03.Sequences.Sequence
import u03.Sequences.Sequence.{Cons, Nil}

class PersonTest:

  val p1: Person = Teacher("mario", "matematica")
  val p2: Person = Teacher("marco", "informatica")
  val p3: Person = Student("filippo", 2002)
  val p4: Person = Student("federico", 2004)
  val sequence1: Sequence[Person] = Cons(p1, Cons(p2, Cons(p3, Nil())))
  val sequence2: Sequence[Person] = Cons(p3, Cons(p4, Nil()))

  @Test def testGetCourses() =
    val courses: Sequence[String] = Cons("matematica", Cons("informatica", Nil()))
    assertEquals(courses, getCoursesOfTeachers(sequence1))
    assertEquals(Nil(), getCoursesOfTeachers(sequence2))

  @Test def testGetTotalNumberOfCourses() =
    assertEquals(2, Modules.getTotalNumberOfCourses(sequence1))
    assertEquals(0, Modules.getTotalNumberOfCourses(sequence2))