module.exports = {
    extends: ['@commitlint/config-conventional'],
    rules: {
        'type-enum': [
            2,
            'always',
            ['feat', 'fix', 'docs', 'refactor', 'test', 'chore', 'perf', 'ci', 'revert']
        ],
        'subject-max-length': [2, 'always', 72],
    }
};