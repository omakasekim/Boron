# Boron

리플렉션과 객체 할당 없이 동작하는 Kotlin KSP2 컴파일 타임 코드 생성기입니다. 클래스에 애노테이션을 추가하면 속성 변경 비트마스크(`@FastDiff`)와 단일 `Long`에 모든 필드를 패킹하는 인라인 값 클래스(`@Bitpack`)를 컴파일 시점에 생성합니다.

[English Documentation](README.md)

## 핵심 기능

- **`@FastDiff`**: 최대 64개 속성의 변경 여부를 비트마스크(`Int` / `Long`)로 계산하는 `diffMask(other)`, `changed(other)`, `count`, `has`, `hasAny`, `hasAll`, 할당 없는 `inline fun forEach`, `names`, 데이터 클래스용 `applyDiff(other, mask)`를 생성합니다. NaN·`-0.0`, 중첩 배열(`contentDeepEquals`), 부호 없는 배열 및 `typealias`를 안전하게 비교합니다.
- **`@Bitpack`**: `Boolean`, 정수형(부호 있음/없음), `Char`, `Float`/`Double`(IEEE 754 원시 비트), `enum`(널 허용 포함), 그리고 중첩 `@Bitpack` 클래스를 단일 64비트 `@JvmInline value class`에 패킹합니다.
- **0.3.0 신규 기능**:
  - 언패킹 없이 두 패킹 값을 비트 단위로 비교하는 `PackedFoo.diffMask(other)` (제로 할당).
  - 외부/네트워크 `Long` 값의 미사용 상위 비트, 열거형 범위, 중첩 `@Bitpack` 필드를 재귀 검증하는 `PackedFoo.isValid(raw)`, `fromRaw(raw)`, `fromRawOrNull(raw)` 및 `PackedFoo.BITS`.
  - `@FastDiff`용 `changed`, `count`, `has`, `hasAny`, `hasAll`, `inline forEach` 헬퍼.

## 빌드 및 테스트

```sh
./gradlew --no-daemon build
```

## 라이선스

MIT License. 세부 사항은 [LICENSE](LICENSE) 파일을 참조하십시오.
